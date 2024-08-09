package sort;

/**
 * 冒泡排序
 */
public class _01MaoPao {
  // 冒泡排序
  public void maoPao(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length - i - 1; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = {20, 34, 3, 4, 5, 60, 7, 8, 19, 10};
    _01MaoPao maoPao = new _01MaoPao();
    maoPao.maoPao(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }
}
