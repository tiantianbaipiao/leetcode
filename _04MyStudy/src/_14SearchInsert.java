/**
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 */
public class _14SearchInsert {
  public int searchInsert(int[] nums, int target) {
    // 初始化首尾
    int left = 0;
    int right = nums.length-1;
    // 循环比较 如果比nums[mid]大则移动left反之则移动right
    while (left <= right){
      int mid = (left + right) / 2;
      if(nums[mid] == target){
        return mid;
      } else if (nums[mid] < target){
        left = mid + 1;
      }else {
        right = mid -1;
      }
    }
    return left;
  }
}
