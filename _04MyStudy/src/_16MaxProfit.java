/**
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * [7,1,5,3,6,4]
 * 5
 *
 */
public class _16MaxProfit {

  // 超出时间限制
  public int maxProfit(int[] prices) {
    int money = 0;
    int maxMoney = 0;
    for (int i = 0; i < prices.length; i++){
      for (int j = i+1; j < prices.length; j++){
        if(prices[j] - prices[i] > money){
          money = prices[j] - prices[i];
        }
        // 更新最大值
        if (money > maxMoney) {
          maxMoney = money;
        }
      }
    }
    return maxMoney;
  }

  public int maxProfit_1(int[] prices) {
    if(prices == null || prices.length < 2){
      return 0;
    }
    // 假设第一个的价格是最低的
    int minPrices = prices[0];
    // 定义个变量用于存储最大值
    int maxMoney = 0;
    for (int i = 0; i < prices.length; i++){
      if(prices[i] > minPrices){
        maxMoney = Math.max(maxMoney,prices[i]-minPrices);
      }else {
        minPrices = prices[i];
      }
    }
    return maxMoney;
  }

  public static void main(String[] args) {
    _16MaxProfit solution = new _16MaxProfit();
    int[] prices = {7, 1, 5, 3, 6, 4};
    int i = solution.maxProfit_1(prices);
    System.out.println(i);
  }
}
