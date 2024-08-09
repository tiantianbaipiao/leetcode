public class _24MaxProfit {
  /**
   * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
   *
   * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
   *
   * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
   */
  public int maxProfit(int[] prices) {
    // Check if the input array is null or too short to make a profit.
    if (prices == null || prices.length < 2) {
      return 0;
    }

    int minPrice = prices[0];  // Initialize the minimum price seen so far.
    int maxProfit = 0;         // Initialize the maximum profit.

    // Iterate through the prices starting from the second day.
    for (int i = 1; i < prices.length; i++) {
      // If the current price is higher than the minimum price,
      // update the maximum profit if selling today would result in a higher profit.
      if (prices[i] > minPrice) {
        maxProfit = Math.max(maxProfit, prices[i] - minPrice);
      } else {
        // Update the minimum price if the current price is lower.
        minPrice = prices[i];
      }
    }

    // Return the maximum profit found.
    return maxProfit;
  }

}
