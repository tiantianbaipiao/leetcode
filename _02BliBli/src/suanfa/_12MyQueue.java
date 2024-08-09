package suanfa;

import java.util.Stack;

public class _12MyQueue {
  // 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）
  public static class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public MyQueue() {
      stack1 = new Stack<>();
      stack2 = new Stack<>();
    }
    public void push(int x) {
      stack1.push(x);
    }
    public int pop() {
      if (stack2.isEmpty()) {
        while (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
        }
      }
      return stack2.pop();
    }
    public int peek() {
      if (stack2.isEmpty()) {
        while (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
        }
      }
      return stack2.peek();
    }
    public boolean empty() {
      return stack1.isEmpty() && stack2.isEmpty();
    }
  }
}
