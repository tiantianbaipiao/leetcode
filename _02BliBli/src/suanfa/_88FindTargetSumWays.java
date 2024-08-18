package suanfa;

/**
 * 给你一个非负整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class _88FindTargetSumWays {
  public int findTargetSumWays(int[] nums, int target) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }

    // 如果总和与目标和之差为奇数，则无法通过加减号组合达到目标和
    if ((sum + target) % 2 != 0) {
      return 0;
    }

    // 确保 sum + target 的值是非负数
    if(sum + target < 0){
      return 0;
    }

    int bagSize = (sum + target) / 2;

    // 创建动态规划数组
    int[] dp = new int[bagSize + 1];
    dp[0] = 1;  // 初始状态

    // 动态规划填充数组
    for (int num : nums) {
      for (int j = bagSize; j >= num; j--) {
        dp[j] += dp[j - num];
      }
    }

    return dp[bagSize];
  }

  public static void main(String[] args) {
    _88FindTargetSumWays solution = new _88FindTargetSumWays();
    int[] nums = {1, 1, 1, 1, 1};
    int target = 3;
    int result = solution.findTargetSumWays(nums, target);
    System.out.println("Result: " + result);  // 输出: 5
  }
}

