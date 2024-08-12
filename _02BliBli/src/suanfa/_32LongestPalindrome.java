package suanfa;

/**
 *  给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class _32LongestPalindrome {
  public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";

    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = expandAroundCenter(s, i, i); // 当前字符为中心
      int len2 = expandAroundCenter(s, i, i + 1); // 当前字符和下一个字符为中心
      int maxLen = Math.max(len1, len2);
      if (maxLen > end - start) {
        start = i - (maxLen - 1) / 2;
        end = i + maxLen / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  private int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1; // 减去最后一个不匹配的左右边界
  }

  // 测试代码
  public static void main(String[] args) {
    _32LongestPalindrome finder = new _32LongestPalindrome();
    String testString = "babad";
    System.out.println("Longest Palindromic Substring: " + finder.longestPalindrome(testString));
  }
}

