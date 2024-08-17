/**
 * 要求计算最佳买卖股票时机含冷冻期的情况。给定一个整数数组 prices，
 * 其中 prices[i] 是第 i 天一支股票的价格。设计一个算法来计算你所能获取的最大利润。
 * 你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 但是，你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票），
 * 并且卖出股票后需要等待一天才能再次购买。
 */
public class _79MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int hold = Integer.MIN_VALUE, sell = 0, rest = 0;

        for (int price : prices) {
            // 更新状态
            int prevHold = hold;
            hold = Math.max(hold, rest - price); // 持有股票，要么前一天持有，要么前一天休息今天买入
            rest = Math.max(rest, sell);          // 休息，要么前一天休息，要么前一天卖出
            sell = prevHold + price;             // 卖出股票，前一天必须持有股票
        }

        // 最大收益是卖出股票或处于冷冻期的状态
        return Math.max(sell, rest);
    }
}
