# LeetCode 232. Implement Queue using Stacks

## 题意

使用栈实现队列的下列操作：

- push(x) -- 将一个元素放入队列的尾部。
- pop() -- 从队列首部移除元素。
- peek() -- 返回队列首部的元素。
- empty() -- 返回队列是否为空。
- 说明:
    - 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
    - 你所使用的语言也许不支持栈。你可以使用 list 或者 deque (双端队列) 来模拟一个栈，只要是标准的栈操作即可。
    - 假设所有操作都是有效的 (例如，一个空的队列不会调用 pop 或者 peek 操作)。

## 题解

1. 使用两个栈，一个用于存储数据，一个用于辅助操作
2. push 操作时，将数据压入数据栈
3. pop 操作时，将数据栈中的数据依次弹出并压入辅助栈，弹出辅助栈的栈顶元素，再将辅助栈中的数据依次弹出并压入数据栈
4. peek 操作时，将数据栈中的数据依次弹出并压入辅助栈，弹出辅助栈的栈顶元素，再将辅助栈中的数据依次弹出并压入数据栈
5. empty 操作时，判断数据栈是否为空
6. 时间复杂度：O(n)，空间复杂度：O(n)

## 代码

```python

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.data = []
        self.helper = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.data.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        while self.data:
            self.helper.append(self.data.pop())
        res = self.helper.pop()
        while self.helper:
            self.data.append(self.helper.pop())
        return res

    def peek(self) -> int:
        """
        Get the front element.
        """
        while self.data:
            self.helper.append(self.data.pop())
        res = self.helper[-1]
        while self.helper:
            self.data.append(self.helper.pop())
        return res

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return not self.data

```

**java**

```java

class MyQueue {

    private Stack<Integer> data;
    private Stack<Integer> helper;

    /** Initialize your data structure here. */
    public MyQueue() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        data.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!data.isEmpty()) {
            helper.push(data.pop());
        }
        int res = helper.pop();
        while (!helper.isEmpty()) {
            data.push(helper.pop());
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        while (!data.isEmpty()) {
            helper.push(data.pop());
        }
        int res = helper.peek();
        while (!helper.isEmpty()) {
            data.push(helper.pop());
        }
        return res;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return data.isEmpty();
    }
}

```