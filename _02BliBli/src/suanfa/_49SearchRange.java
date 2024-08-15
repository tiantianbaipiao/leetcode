package suanfa;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class _49SearchRange {
  public int[] searchRange(int[] nums, int target) {
    int leftIndex = binarySearchLeft(nums, target);
    int rightIndex = binarySearchRight(nums, target);

    // 如果没有找到目标值，则返回 [-1, -1]
    if (leftIndex == nums.length || nums[leftIndex] != target) {
      return new int[]{-1, -1};
    }

    return new int[]{leftIndex, rightIndex};
  }

  private int binarySearchLeft(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  private int binarySearchRight(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] <= target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return right;
  }
}

