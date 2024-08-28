package suanfa;

import java.util.Stack;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 */
public class _65Calculate {
  public int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    int num = 0;
    char sign = '+';
    int length = s.length();

    for (int i = 0; i < length; i++) {
      char currentChar = s.charAt(i);

      if (Character.isDigit(currentChar)) {
        num = num * 10 + (currentChar - '0');
      }

      if (!Character.isDigit(currentChar) && currentChar != ' ' || i == length - 1) {
        if (sign == '+') {
          stack.push(num);
        } else if (sign == '-') {
          stack.push(-num);
        } else if (sign == '*') {
          int top = stack.pop();
          stack.push(top * num);
        } else if (sign == '/') {
          int top = stack.pop();
          stack.push(top / num);
        }

        sign = currentChar;
        num = 0;
      }
    }

    int result = 0;
    while (!stack.isEmpty()) {
      result += stack.pop();
    }

    return result;
  }

  public static void main(String[] args) {
    _65Calculate solution = new _65Calculate();
    String expression = "3+2*2";
    System.out.println(solution.calculate(expression)); // 输出结果应为 7
  }
}

