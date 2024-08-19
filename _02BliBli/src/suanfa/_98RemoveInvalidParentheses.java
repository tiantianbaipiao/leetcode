package suanfa;

import java.util.*;

/**
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 */
public class _98RemoveInvalidParentheses {

  // 删除无效的括号
  public List<String> removeInvalidParentheses(String s) {
    Set<String> visited = new HashSet<>();  // 记录已访问的状态
    List<String> result = new LinkedList<>();  // 存储结果
    Queue<String> queue = new LinkedList<>();  // 广度优先搜索队列
    boolean found = false;  // 是否找到有效的括号组合

    queue.offer(s);
    visited.add(s);

    while (!queue.isEmpty()) {
      String str = queue.poll();

      if (isValid(str)) {  // 如果当前字符串有效
        found = true;
        result.add(str);  // 添加到结果列表
      }

      if (found) continue;  // 如果已经找到有效组合，跳过后续操作

      for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c == '(' || c == ')') {  // 只考虑括号
          String next = str.substring(0, i) + str.substring(i + 1);
          if (!visited.contains(next)) {  // 如果未访问过
            visited.add(next);  // 添加到已访问集合
            queue.offer(next);  // 添加到队列
          }
        }
      }
    }

    return result;
  }

  // 检查括号是否有效
  private boolean isValid(String s) {
    int count = 0;
    for (char c : s.toCharArray()) {
      if (c == '(') count++;
      if (c == ')') count--;
      if (count < 0) return false;  // 如果右括号多于左括号，直接返回
    }
    return count == 0;  // 所有括号都匹配
  }

  public static void main(String[] args) {
    _98RemoveInvalidParentheses solution = new _98RemoveInvalidParentheses();
    String s = "()())()";
    List<String> result = solution.removeInvalidParentheses(s);
    System.out.println("Results: " + result);
  }
}

