package sort;

/**
 * 插入排序
 */
public class _03ChaRu {
  // 插入排序
  public static void chaRu(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      int temp = nums[i];
      int j = i - 1;
      while (j >= 0 && nums[j] > temp) {
        nums[j + 1] = nums[j];
        j--;
      }
      nums[j + 1] = temp;
    }
  }

  public static void main(String[] args) {
    int[] nums = {3, 2, 1, 5, 4};
    chaRu(nums);
    for (int i : nums) {
      System.out.print(i + " ");
    }
  }
}
