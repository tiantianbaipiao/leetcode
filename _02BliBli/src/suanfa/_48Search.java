package suanfa;

/**
 * leetcode 33
 */
public class _48Search {
  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] == target) {
        return mid;
      }

      // 确定哪边是有序的
      if (nums[left] <= nums[mid]) { // 左半部分有序
        if (nums[left] <= target && target < nums[mid]) { // 目标值在左半部分
          right = mid - 1;
        } else { // 目标值在右半部分
          left = mid + 1;
        }
      } else { // 右半部分有序
        if (nums[mid] < target && target <= nums[right]) { // 目标值在右半部分
          left = mid + 1;
        } else { // 目标值在左半部分
          right = mid - 1;
        }
      }
    }

    return -1; // 没有找到目标值
  }
}

