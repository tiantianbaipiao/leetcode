package suanfa;

/**
 * 编写一个函数来判断一个字符串 s 是否能与一个包含特殊字符的模式 p 匹配。模式 p 中的特殊字符包括 ?
 * 和 *，其中 ? 可以匹配任意单个字符，* 可以匹配任意数量的任意字符（包括零个字符）。
 */
public class _40IsMatch {
  public boolean isMatch(String s, String p) {
    int sLen = s.length(), pLen = p.length();
    boolean[][] dp = new boolean[sLen + 1][pLen + 1]; // 动态规划表

    dp[0][0] = true; // 空字符串与空模式匹配成功

    // 初始化第一行
    for (int j = 1; j <= pLen; j++) {
      if (p.charAt(j - 1) == '*') {
        dp[0][j] = dp[0][j - 1];
      }
    }

    // 动态规划填充
    for (int i = 1; i <= sLen; i++) {
      for (int j = 1; j <= pLen; j++) {
        if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1]; // 当前字符匹配，向前移动一步
        } else if (p.charAt(j - 1) == '*') {
          dp[i][j] = dp[i - 1][j] || dp[i][j - 1]; // * 可以匹配任意数量的字符
        }
      }
    }

    return dp[sLen][pLen]; // 返回最终匹配结果
  }

  public static void main(String[] args) {
    System.out.println(new _40IsMatch().isMatch("aa", "a"));
  }
}
