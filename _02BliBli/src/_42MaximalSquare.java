/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class _42MaximalSquare {
  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int rows = matrix.length;
    int cols = matrix[0].length;
    int maxSide = 0;
    int[][] dp = new int[rows + 1][cols + 1];

    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= cols; j++) {
        if (matrix[i - 1][j - 1] == '1') {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
          maxSide = Math.max(maxSide, dp[i][j]);
        }
      }
    }

    return maxSide * maxSide;
  }
}

