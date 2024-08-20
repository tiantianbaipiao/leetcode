/**
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 */
public class _04RemoveDuplicates {

  // 删除有序数组中的重复项(快慢指针法)
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;

    int slow = 0;
    for (int fast = 1; fast < nums.length; fast++) {
      if (nums[fast] != nums[slow]) {
        slow++;
        nums[slow] = nums[fast];
      }
    }

    return slow + 1;
  }

  public static void main(String[] args) {
    _04RemoveDuplicates solution = new _04RemoveDuplicates();
    int[] nums = {1, 1, 2};
    int newLength = solution.removeDuplicates(nums);
    System.out.println("New Length: " + newLength);
    for (int i = 0; i < newLength; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.println();
  }
}

