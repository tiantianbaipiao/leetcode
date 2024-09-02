package suanfa;

import java.util.Arrays;

public class _128MaxSubarraySumCircular {

    /**
     * 计算环形子数组的最大和
     * @param nums 数组
     * @return 最大子数组和
     */
    public int maxSubarraySumCircular(int[] nums) {
        int maxKadane = kadane(nums); // 使用 Kadane 算法找到最大子数组和
        int totalSum = Arrays.stream(nums).sum(); // 计算数组总和
        int minKadane = kadaneInverted(nums); // 使用 Kadane 算法找到最小子数组和

        // 如果最小子数组和不等于数组总和（即数组中存在正数）
        if (minKadane != totalSum) {
            return Math.max(maxKadane, totalSum - minKadane); // 取最大值
        } else {
            return maxKadane; // 全部为负数的情况
        }
    }

    /**
     * 使用 Kadane 算法找到最大子数组和
     * @param nums 数组
     * @return 最大子数组和
     */
    private int kadane(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    /**
     * 使用 Kadane 算法找到最小子数组和
     * @param nums 数组
     * @return 最小子数组和
     */
    private int kadaneInverted(int[] nums) {
        int minSoFar = nums[0];
        int minEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            minEndingHere = Math.min(nums[i], minEndingHere + nums[i]);
            minSoFar = Math.min(minSoFar, minEndingHere);
        }

        return minSoFar;
    }

    // 测试方法
    public static void main(String[] args) {
        _128MaxSubarraySumCircular solution = new _128MaxSubarraySumCircular();
        int[] nums = {1, -2, 3, -2};
        int result = solution.maxSubarraySumCircular(nums);
        System.out.println(result); // 应输出 3

        int[] nums2 = {5, -3, 5};
        int result2 = solution.maxSubarraySumCircular(nums2);
        System.out.println(result2); // 应输出 10

        int[] nums3 = {-3, -2, -3};
        int result3 = solution.maxSubarraySumCircular(nums3);
        System.out.println(result3); // 应输出 -2
    }
}
