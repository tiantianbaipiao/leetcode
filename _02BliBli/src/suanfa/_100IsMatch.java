package suanfa;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s 的，而不是部分字符串。
 */
public class _100IsMatch {

  // 正则表达式匹配
  public boolean isMatch(String s, String p) {
    int m = s.length(), n = p.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;  // 空字符串与空正则表达式的匹配

    // 初始化第一行
    for (int j = 2; j <= n; j++) {
      if (p.charAt(j - 1) == '*') {
        dp[0][j] = dp[0][j - 2];
      }
    }

    // 动态规划
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (p.charAt(j - 1) == '*') {
          dp[i][j] = dp[i][j - 2];  // 忽略模式中的 `'*'` 和其前一个字符
          if (p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2)) {
            dp[i][j] |= dp[i - 1][j];  // 当前字符与 `'*'` 前的字符匹配
          }
        }
      }
    }

    return dp[m][n];
  }

  public static void main(String[] args) {
    _100IsMatch solution = new _100IsMatch();
    String s = "aa";
    String p = "a";
    boolean match = solution.isMatch(s, p);
    System.out.println("Match: " + match);
  }
}

