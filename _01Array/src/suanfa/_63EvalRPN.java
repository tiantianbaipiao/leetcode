package suanfa;

import java.util.Stack;

/**
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 *
 * 请你计算该表达式。返回一个表示表达式值的整数。
 */
public class _63EvalRPN {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>(); // 创建一个栈用来存储数字

    for (String token : tokens) {
      if (isOperator(token)) { // 判断是否为运算符
        int operand2 = stack.pop(); // 弹出第二个操作数
        int operand1 = stack.pop(); // 弹出第一个操作数
        int result = performOperation(operand1, operand2, token); // 执行运算
        stack.push(result); // 将结果压入栈中
      } else {
        stack.push(Integer.parseInt(token)); // 将数字压入栈中
      }
    }

    return stack.pop(); // 最终栈中剩下的唯一元素即为计算结果
  }

  private boolean isOperator(String token) {
    return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
  }

  private int performOperation(int operand1, int operand2, String operator) {
    switch (operator) {
      case "+":
        return operand1 + operand2;
      case "-":
        return operand1 - operand2;
      case "*":
        return operand1 * operand2;
      case "/":
        return operand1 / operand2; // 向零截断
      default:
        throw new IllegalArgumentException("Invalid operator: " + operator);
    }
  }

  public static void main(String[] args) {
    _63EvalRPN solution = new _63EvalRPN();
    String[] tokens = {"2", "1", "+", "3", "*"};
    System.out.println(solution.evalRPN(tokens)); // 输出结果应为 9
  }
}


