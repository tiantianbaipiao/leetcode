/**
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1]
 * 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。
 * 如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * 求所能获得硬币的最大数量
 */
public class _99MaxCoins {

  // 戳破气球获取最大硬币数
  public int maxCoins(int[] nums) {
    int n = nums.length;
    int[] newNums = new int[n + 2];
    System.arraycopy(nums, 0, newNums, 1, n);
    newNums[0] = newNums[n + 1] = 1;  // 边界条件

    int[][] dp = new int[n + 2][n + 2];

    for (int len = 1; len <= n; len++) {  // 区间长度
      for (int left = 1; left <= n - len + 1; left++) {  // 区间的起始位置
        int right = left + len - 1;  // 区间的结束位置
        for (int k = left; k <= right; k++) {  // 枚举最后一个戳破的气球
          int coins = newNums[left - 1] * newNums[k] * newNums[right + 1];
          coins += dp[left][k - 1] + dp[k + 1][right];
          dp[left][right] = Math.max(dp[left][right], coins);
        }
      }
    }

    return dp[1][n];
  }

  public static void main(String[] args) {
    _99MaxCoins solution = new _99MaxCoins();
    int[] nums = {3, 1, 5, 8};
    int maxCoins = solution.maxCoins(nums);
    System.out.println("Max Coins: " + maxCoins);
  }
}

