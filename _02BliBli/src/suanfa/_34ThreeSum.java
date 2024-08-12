package suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 */
public class _34ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums); // 排序

    for (int i = 0; i < nums.length - 2; i++) {
      // 如果当前数字大于0，则后面不可能有三个数加和为0
      if (nums[i] > 0) break;

      // 跳过重复元素
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum < 0) {
          left++; // 需要更大的值
        } else if (sum > 0) {
          right--; // 需要更小的值
        } else {
          // 找到一个三元组
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));

          // 跳过重复元素
          while (left < right && nums[left] == nums[left + 1]) left++;
          while (left < right && nums[right] == nums[right - 1]) right--;

          left++;
          right--;
        }
      }
    }
    return result;
  }

  // 测试代码
  public static void main(String[] args) {
    _34ThreeSum finder = new _34ThreeSum();
    int[] nums = {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> result = finder.threeSum(nums);
    for (List<Integer> list : result) {
      System.out.println(list);
    }
  }
}

