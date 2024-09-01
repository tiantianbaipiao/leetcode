import java.util.Stack;

public class _105CalculateExpression {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        int result = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 如果是数字，则累加到当前数字变量中
            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            }

            // 如果遇到运算符或到达字符串末尾
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(currentNumber);
                } else if (sign == '-') {
                    stack.push(-currentNumber);
                }

                // 更新当前数字变量和运算符
                sign = c;
                currentNumber = 0;
            }

            // 如果遇到左括号，递归处理括号内的表达式
            if (c == '(') {
                int closeIndex = findMatchingParentheses(s, i);
                int subResult = calculate(s.substring(i + 1, closeIndex));
                if (sign == '+') {
                    stack.push(subResult);
                } else if (sign == '-') {
                    stack.push(-subResult);
                }
                i = closeIndex;
            }
        }

        // 计算栈中所有元素的总和
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    private int findMatchingParentheses(String s, int openIndex) {
        int count = 1;
        for (int i = openIndex + 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count == 0) {
                return i;
            }
        }
        return -1; // 不应该发生
    }

    public static void main(String[] args) {
        _105CalculateExpression solution = new _105CalculateExpression();
        String expression = "(1+(4+5+2)-3)+(6+8)";
        int result = solution.calculate(expression);
        System.out.println(result); // 输出: 23
    }
}
