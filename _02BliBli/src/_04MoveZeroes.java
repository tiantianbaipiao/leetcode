// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//请注意 ，必须在不复制数组的情况下原地对数组进行操作。
public class _04MoveZeroes {
  public void moveZeroes(int[] nums) {
    // 使用更具描述性的变量名，以提高代码的可读性
    int nonZeroIndex = 0;

    // 第一次遍历：将非零元素移动到数组的前面
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        // 当前元素非零时，将其赋值给正确的位置
        nums[nonZeroIndex++] = nums[i];
      }
    }

    // 第二次遍历：将剩余的位置置零
    for (int i = nonZeroIndex; i < nums.length; i++) {
      nums[i] = 0;
    }
  }

}
