/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class _85PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        
        // 计算数组的总和
        for (int num : nums) {
            sum += num;
        }
        
        // 如果总和是奇数，则无法分割成两个等和的子集
        if (sum % 2 != 0) {
            return false;
        }
        
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // 初始状态
        
        // 动态规划填充 dp 数组
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        
        return dp[target];
    }

    public static void main(String[] args) {
        _85PartitionEqualSubsetSum solution = new _85PartitionEqualSubsetSum();
        int[] nums = {1, 5, 11, 5};
        boolean result = solution.canPartition(nums);
        System.out.println(result);  // 输出: true
    }
}
