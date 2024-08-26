package suanfa;

/**
 * 给定一支股票每天的价格，你需要计算出在无限次交易限制下的最大利润。
 */
public class _46MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int totalProfit = 0;

        // 从第二天开始遍历价格数组
        for (int i = 1; i < prices.length; i++) {
            // 如果今天的股价比昨天高，则说明可以卖出获得利润
            if (prices[i] > prices[i - 1]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }

        return totalProfit;
    }
}
