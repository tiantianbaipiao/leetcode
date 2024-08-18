import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 */
public class _90SubarraySum {
  public int subarraySum(int[] nums, int k) {
    int count = 0;  // 记录满足条件的子数组个数
    int sum = 0;    // 当前子数组的和
    Map<Integer, Integer> prefixSumCount = new HashMap<>();  // 前缀和出现的次数
    prefixSumCount.put(0, 1);  // 初始状态：前缀和为 0 的子数组有一个

    for (int num : nums) {
      sum += num;  // 更新当前子数组的和
      // 查找满足 sum - k 的前缀和出现的次数
      count += prefixSumCount.getOrDefault(sum - k, 0);
      // 更新前缀和出现的次数
      prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
    }

    return count;
  }

  public static void main(String[] args) {
    _90SubarraySum solution = new _90SubarraySum();
    int[] nums = {1, 1, 1};
    int k = 2;
    int result = solution.subarraySum(nums, k);
    System.out.println("Result: " + result);  // 输出: 2
  }
}

