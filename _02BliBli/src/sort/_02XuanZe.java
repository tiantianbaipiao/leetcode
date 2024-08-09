package sort;

/**
 * 选择排序
 */
public class _02XuanZe {
  // 选择排序
  public void xuanZe(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int min = nums[i];
      int minIndex = i;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] < min) {
          min = nums[j];
          minIndex = j;
        }
      }
      if (minIndex != i) {
        nums[minIndex] = nums[i];
        nums[i] = min;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = {1, 5, 3, 2, 4};
    _02XuanZe xuanZe = new _02XuanZe();
    xuanZe.xuanZe(nums);
    System.out.println("排序结果：" + java.util.Arrays.toString(nums));
  }
}
