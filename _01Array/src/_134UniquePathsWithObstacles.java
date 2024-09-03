public class _134UniquePathsWithObstacles {

    /**
     * 在一个障碍物网格中寻找从左上角到右下角的路径数量
     * @param obstacleGrid 障碍物网格
     * @return 路径数量
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // 如果起点有障碍物，则无法到达终点
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // 初始化 dp 数组
        int[] dp = new int[n];
        dp[0] = 1; // 起点设为 1

        // 动态规划填充 dp 数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果当前位置有障碍物，则路径数量为 0
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    // 否则，当前位置的路径数量为左边和上边路径数量之和
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n - 1]; // 返回右下角的路径数量
    }
}
