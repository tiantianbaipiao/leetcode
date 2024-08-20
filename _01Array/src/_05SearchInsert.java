/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置
 */
public class _05SearchInsert {

  // 搜索插入位置(二分查找)
  public int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return left;
  }

  public static void main(String[] args) {
    _05SearchInsert solution = new _05SearchInsert();
    int[] nums = {1, 3, 5, 6};
    int target = 5;
    int index = solution.searchInsert(nums, target);
    System.out.println("Index: " + index);
  }
}

