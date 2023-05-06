package queue_and_stack;

import java.util.Stack;

/**
 * @author ginga
 * @since 29/4/2023 上午11:16
 */
public class LeetCode232 {
}

class MyQueue {
    private final Stack<Integer> in;
    private final Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        int v = peek();
        out.pop();
        return v;
    }

    public int peek() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        return in.empty() && out.empty();
    }
}
