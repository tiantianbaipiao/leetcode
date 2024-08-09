import java.util.Stack;

public class _22IsValid {
  // 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。有效字符串需满足：
  // 1. 左括号必须用相同类型的右括号闭合。
  // 2. 左括号必须以正确的顺序闭合。
  // 3. 每个右括号都有一个对应的相同类型的左括号。
  // 4. 注意空字符串可被认为是有效字符串。
  public static boolean isValid(String s) {
    // 防止传入 null 值导致 NullPointerException
    if (s == null) {
      return true; // 根据题意, 空字符串被认为是有效的
    }

    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) return false;

        char top = stack.pop();
        if ((c == ')' && top != '(') ||
            (c == '}' && top != '{') ||
            (c == ']' && top != '[')) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }

}
