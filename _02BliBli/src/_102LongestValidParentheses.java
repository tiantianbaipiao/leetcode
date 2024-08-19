/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号
 * 子串
 * 的长度。
 */
public class _102LongestValidParentheses {

  // 最长有效括号
  public int longestValidParentheses(String s) {
    int n = s.length();
    if (n <= 1) return 0;

    int[] dp = new int[n];
    int maxLength = 0;

    for (int i = 1; i < n; i++) {
      if (s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(') {
          dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
        } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
          dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
        }
        maxLength = Math.max(maxLength, dp[i]);
      }
    }

    return maxLength;
  }

  public static void main(String[] args) {
    _102LongestValidParentheses solution = new _102LongestValidParentheses();
    String s = "(()";
    int length = solution.longestValidParentheses(s);
    System.out.println("Longest Valid Parentheses Length: " + length);
  }
}

