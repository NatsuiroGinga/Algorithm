# go中的context

## 1. context的作用

context是go中的一个包，它的作用是在多个goroutine之间传递上下文信息，比如请求的截止时间、请求的trace信息等。

## 2. context的使用

context的使用非常简单，它提供了两个方法，一个是`context.WithCancel`，一个是`context.WithDeadline`
，这两个方法都会返回一个context对象和一个cancel方法，当我们需要取消context时，可以调用cancel方法。

```go

func main() {
    ctx, cancel := context.WithCancel(context.Background())
    go func(ctx context.Context) {
        for {
            select {
            case <-ctx.Done():
                fmt.Println("goroutine1 exit")
                return
            default:
                fmt.Println("goroutine1 running")
                time.Sleep(time.Second)
            }
        }
    }(ctx)
    go func(ctx context.Context) {
        for {
            select {
            case <-ctx.Done():
                fmt.Println("goroutine2 exit")
                return
            default:
                fmt.Println("goroutine2 running")
                time.Sleep(time.Second)
            }
        }
    }(ctx)
    time.Sleep(3 * time.Second)
    cancel()
    time.Sleep(3 * time.Second)
}

```

上面的代码中，我们创建了两个goroutine，它们都会在ctx.Done()返回的channel上阻塞，当我们调用cancel方法时，这两个goroutine都会退出。

## 3. context的传递

context的另一个作用是在多个goroutine之间传递上下文信息，比如请求的截止时间、请求的trace信息等。我们可以通过context的`WithValue`
方法传递一个key-value的键值对，然后在子goroutine中通过`Value`方法获取对应的值。

```go

func main() {
    ctx, cancel := context.WithCancel(context.Background())
    ctx = context.WithValue(ctx, "name", "gopher")
    go func(ctx context.Context) {
        for {
            select {
            case <-ctx.Done():
                fmt.Println("goroutine1 exit")
                return
            default:
                fmt.Println("goroutine1 running")
                fmt.Println(ctx.Value("name"))
                time.Sleep(time.Second)
            }
        }
    }(ctx)
    go func(ctx context.Context) {
        for {
            select {
            case <-ctx.Done():
                fmt.Println("goroutine2 exit")
                return
            default:
                fmt.Println("goroutine2 running")
                fmt.Println(ctx.Value("name"))
                time.Sleep(time.Second)
            }
        }
    }(ctx)
    time.Sleep(3 * time.Second)
    cancel()
    time.Sleep(3 * time.Second)
}

```

## 4. context的使用场景

context的使用场景有很多，比如我们在开发一个http
server时，每个请求都会创建一个goroutine，那么我们就可以使用context来控制每个请求的截止时间，当请求的截止时间到了之后，我们就可以自动取消这个请求对应的goroutine，防止goroutine泄露。

```go

func main() {
    http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
        ctx, cancel := context.WithCancel(context.Background())
        go func(ctx context.Context) {
            select {
            case <-ctx.Done():
                fmt.Println("goroutine1 exit")
                return
            default:
                fmt.Println("goroutine1 running")
                time.Sleep(time.Second)
            }
        }(ctx)
        go func(ctx context.Context) {
            select {
            case <-ctx.Done():
                fmt.Println("goroutine2 exit")
                return
            default:
                fmt.Println("goroutine2 running")
                time.Sleep(time.Second)
            }
        }(ctx)
        time.Sleep(3 * time.Second)
        cancel()
        time.Sleep(3 * time.Second)
    })
    http.ListenAndServe(":8080", nil)
}

```

## 5. context的实现原理

context的实现原理非常简单，它是一个结构体，里面包含了一个`cancelCtx`结构体，这个结构体里面包含了一个`done`
的channel，当我们调用cancel方法时，会关闭这个channel，然后所有的goroutine都会收到这个消息，然后退出。

```go

type Context interface {
    Deadline() (deadline time.Time, ok bool)
    Done() <-chan struct{}
    Err() error
    Value(key interface{}) interface{}
}

type emptyCtx int

func (*emptyCtx) Deadline() (deadline time.Time, ok bool) {
    return
}

func (*emptyCtx) Done() <-chan struct{} {
    return nil
}

func (*emptyCtx) Err() error {
    return nil
}

func (*emptyCtx) Value(key interface{}) interface{} {
    return nil
}

var (
    background = new(emptyCtx)
    todo       = new(emptyCtx)
)

type cancelCtx struct {
    Context

    done chan struct{}
    err  error
}

func (c *cancelCtx) Done() <-chan struct{} {
    return c.done
}

func (c *cancelCtx) Err() error {
    return c.err
}

func WithCancel(parent Context) (ctx Context, cancel CancelFunc) {
    c := new(cancelCtx)
    propagateCancel(parent, c)
    return c, func() { c.cancel(true, Canceled) }
}

func propagateCancel(parent Context, child canceler) {
    if parent.Done() == nil {
        return // parent is never canceled
    }
    if p, ok := parentCancelCtx(parent); ok {
        p.mu.Lock()
        if p.err != nil {
            // parent has already been canceled
            child.cancel(false, p.err)
        } else {
            if p.children == nil {
                p.children = make(map[canceler]struct{})
            }
            p.children[child] = struct{}{}
        }
        p.mu.Unlock()
    } else {
        go func() {
            select {
            case <-parent.Done():
                child.cancel(false, parent.Err())
            case <-child.Done():
            }
        }()
    }
}

func parentCancelCtx(parent Context) (*cancelCtx, bool) {
    done := parent.Done()
    if done == closedchan || done == nil {
        return nil, false
    }
    p, ok := parent.(*cancelCtx)
    if !ok {
        return nil, false
    }
    if p.done != done {
        // p.done is always the same as <-p.Done(), but <-p.Done() is faster.
        panic("inconsistent cancelCtx state")
    }
    return p, true
}

func (c *cancelCtx) cancel(removeFromParent bool, err error) {
    if err == nil {
        panic("context: internal error: missing cancel error")
    }
    c.mu.Lock()
    if c.err != nil {
        c.mu.Unlock()
        return // already canceled
    }
    c.err = err
    if c.done == nil {
        c.done = closedchan
    } else {
        close(c.done)
    }
    for child := range c.children {
        // NOTE: acquiring the child's lock while holding parent's lock.
        child.cancel(false, err)
    }
    c.children = nil
    c.mu.Unlock()

    if removeFromParent {
        removeChild(parent, c)
    }
}

func removeChild(parent Context, child canceler) {
    p, ok := parentCancelCtx(parent)
    if !ok {
        return
    }
    p.mu.Lock()
    if p.children != nil {
        delete(p.children, child)
    }
    p.mu.Unlock()
}

```

## 6. context的使用注意事项

context的使用注意事项有以下几点：

1. 不要把context放在结构体中，要以参数的方式传递
2. 以context作为参数的函数方法，应该把context作为第一个参数，放在第一位
3. 给一个函数方法传递context的时候，不要传递nil，如果不知道传递什么，就使用context.TODO()
4. context的Value相关方法应该传递必须的数据，不要什么数据都使用这个传递
5. context是线程安全的，可以放心的在多个goroutine中传递
6. 推荐context的使用链是：main函数创建context -> 传递给需要的函数 -> 函数中启动goroutine -> goroutine中创建子context ->
   子context传递给需要的函数 -> 函数中启动goroutine -> 以此类推
7. context是可以被嵌套的，也就是说，父context取消，子context也会被取消
8. context的实现原理非常简单，就是一个结构体，里面包含了一个`cancelCtx`结构体，这个结构体里面包含了一个`done`
   的channel，当我们调用cancel方法时，会关闭这个channel，然后所有的goroutine都会收到这个消息，然后退出
9.
context的使用原则是：不要把context放在结构体中，要以参数的方式传递，也就是说，context应该作为第一个参数传递给函数，而且是第一个参数，这样可以最大限度的避免用户在调用函数时不传递context，导致创建的goroutine无法及时退出，浪费资源。