package suanfa;

/**
 * 编写一个函数来计算给定的只包含数字的字符串有多少种不同的解码方法。
 */
public class _43NumDecodings {
  public int numDecodings(String s) {
    if (s == null || s.isEmpty() || s.charAt(0) == '0') {
      return 0; // 如果字符串为空或第一个字符为0，则无法解码
    }

    int n = s.length();
    int[] dp = new int[n + 1]; // 动态规划数组
    dp[0] = 1; // 空字符串有一种解码方式
    dp[1] = 1; // 单个字符的解码方式

    for (int i = 2; i <= n; i++) {
      // 检查单个字符是否可以解码
      if (s.charAt(i - 1) != '0') {
        dp[i] += dp[i - 1];
      }

      // 检查两个字符是否可以解码
      int twoDigit = Integer.parseInt(s.substring(i - 2, i));
      if (twoDigit >= 10 && twoDigit <= 26) {
        dp[i] += dp[i - 2];
      }
    }

    return dp[n]; // 返回最终的解码方式数量
  }

  public static void main(String[] args) {
    System.out.println(new _43NumDecodings().numDecodings("12"));
  }
}
