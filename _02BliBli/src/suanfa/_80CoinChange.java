package suanfa;

import java.util.Arrays;

/**
 * 要求计算零钱兑换问题。给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 */
public class _80CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // 初始化为一个不可能达到的值
        dp[0] = 0; // 0 金额需要 0 个硬币

        // 动态规划计算最少硬币个数
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // 如果 dp[amount] 仍然为初始值，则无法凑成
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
