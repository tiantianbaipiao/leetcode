package suanfa;

/**
 * 要求找到最长递增子序列的长度。给定一个未排序的整数数组 nums，
 * 需要找到其中最长递增子序列的长度
 */
public class _78LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1; // 初始化 dp 数组的第一个元素为 1

        // 动态规划计算最长递增子序列的长度
        for (int i = 1; i < len; i++) {
            dp[i] = 1; // 初始化 dp[i] 为 1，因为至少可以构成长度为 1 的递增子序列
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 如果 nums[i] 大于 nums[j]，则可以形成更长的递增子序列
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 寻找 dp 数组中的最大值，即为最长递增子序列的长度
        int maxLength = 0;
        for (int i = 0; i < len; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
