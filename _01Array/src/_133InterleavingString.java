public class _133InterleavingString {

    /**
     * 判断两个字符串 s1 和 s2 是否可以通过交错合并得到字符串 s3
     * @param s1 字符串 s1
     * @param s2 字符串 s2
     * @param s3 字符串 s3
     * @return 如果可以通过交错合并得到 s3，则返回 true；否则返回 false
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        // 初始化第一行
        for (int j = 1; j <= s2.length(); j++) {
            if (s3.charAt(j - 1) == s2.charAt(j - 1)) {
                dp[0][j] = dp[0][j - 1];
            } else {
                break;
            }
        }

        // 初始化第一列
        for (int i = 1; i <= s1.length(); i++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1)) {
                dp[i][0] = dp[i - 1][0];
            } else {
                break;
            }
        }

        // 动态规划填充 dp 表
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int index = i + j - 1;
                dp[i][j] = (s3.charAt(index) == s1.charAt(i - 1) && dp[i - 1][j])
                        || (s3.charAt(index) == s2.charAt(j - 1) && dp[i][j - 1]);
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
