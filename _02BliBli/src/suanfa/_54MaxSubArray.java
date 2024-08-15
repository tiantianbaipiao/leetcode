package suanfa;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组
 * 是数组中的一个连续部分。
 */
public class _54MaxSubArray {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int maxSoFar = nums[0];
    int currentMax = nums[0];

    for (int i = 1; i < nums.length; i++) {
      currentMax = Math.max(currentMax + nums[i], nums[i]);
      maxSoFar = Math.max(maxSoFar, currentMax);
    }

    return maxSoFar;
  }
}

