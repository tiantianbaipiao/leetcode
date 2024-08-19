package suanfa;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 */
public class _92MinWindow {
  public String minWindow(String s, String t) {
    int left = 0;  // 窗口左边界
    int right = 0; // 窗口右边界
    int required = t.length();  // 需要匹配的字符数量
    int formed = 0;  // 已经匹配的字符数量
    int minLen = Integer.MAX_VALUE;  // 最小窗口长度
    int minStart = 0;  // 最小窗口的起始位置

    Map<Character, Integer> charCount = new HashMap<>();  // 记录 t 中字符的数量
    for (char c : t.toCharArray()) {
      charCount.put(c, charCount.getOrDefault(c, 0) + 1);
    }

    Map<Character, Integer> windowCharCount = new HashMap<>();  // 记录窗口内字符的数量

    while (right < s.length()) {
      char c = s.charAt(right);
      windowCharCount.put(c, windowCharCount.getOrDefault(c, 0) + 1);

      if (charCount.containsKey(c) && windowCharCount.get(c) <= charCount.get(c)) {
        formed++;
      }

      while (left <= right && formed == required) {
        c = s.charAt(left);

        if (right - left + 1 < minLen) {
          minLen = right - left + 1;
          minStart = left;
        }

        windowCharCount.put(c, windowCharCount.get(c) - 1);
        if (charCount.containsKey(c) && windowCharCount.get(c) < charCount.get(c)) {
          formed--;
        }

        left++;
      }

      right++;
    }

    if (minLen == Integer.MAX_VALUE) {
      return "";
    }

    return s.substring(minStart, minStart + minLen);
  }

  public static void main(String[] args) {
    _92MinWindow solution = new _92MinWindow();
    String s = "aa";
    String t = "aa";
    String result = solution.minWindow(s, t);
    System.out.println("Result: " + result);  // 输出: "aa"
  }
}

