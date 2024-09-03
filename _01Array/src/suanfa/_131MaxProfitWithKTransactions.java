package suanfa;

/**
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class _131MaxProfitWithKTransactions {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // 如果 k 大于或等于 n / 2，则相当于无限次交易
        int n = prices.length;
        if (k >= n / 2) {
            return maxProfitInfiniteTransactions(prices);
        }

        // dp[i][j][0] 表示第 i 天结束时不持有股票且已完成 j 笔交易的最大利润
        // dp[i][j][1] 表示第 i 天结束时持有股票且已完成 j 笔交易的最大利润
        int[][][] dp = new int[n][k + 1][2];

        // 初始化第一天的状态
        for (int j = 0; j <= k; j++) {
            dp[0][j][0] = 0;
            dp[0][j][1] = -prices[0];
        }

        // 动态规划转移方程
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        // 最终不持有股票的状态就是最终的最大利润
        return dp[n - 1][k][0];
    }

    private int maxProfitInfiniteTransactions(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
