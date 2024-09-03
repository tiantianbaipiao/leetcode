package suanfa;

public class _132MaxProfitTwoTransactions {

    /**
     * 计算两次交易的最大利润
     * @param prices 股票价格数组
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // 定义四个状态变量
        // f1[i] 表示第 i 天结束时，已经完成一次交易且不持有股票的最大利润
        // g1[i] 表示第 i 天结束时，已经完成一次交易且持有股票的最大利润
        // f2[i] 表示第 i 天结束时，已经完成两次交易且不持有股票的最大利润
        // g2[i] 表示第 i 天结束时，已经完成两次交易且持有股票的最大利润

        int f1 = 0, g1 = Integer.MIN_VALUE;
        int f2 = 0, g2 = Integer.MIN_VALUE;

        for (int price : prices) {
            // 更新 g1 和 f1
            g1 = Math.max(g1, -price); // 第一次买入
            f1 = Math.max(f1, g1 + price); // 第一次卖出

            // 更新 g2 和 f2
            g2 = Math.max(g2, f1 - price); // 第二次买入
            f2 = Math.max(f2, g2 + price); // 第二次卖出
        }

        return f2; // 最终不持有股票的最大利润
    }

    /**
     * 辅助方法：计算无限次交易的最大利润
     * @param prices 股票价格数组
     * @return 最大利润
     */
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
