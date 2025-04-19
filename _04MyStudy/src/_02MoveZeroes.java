import java.util.Arrays;

/**
 * 力扣 283
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class _02MoveZeroes {
  // 双指针法
  public int[] moveZeroes (int[] nums){
    // 1. 定义两个指针
    int i = 0; int j = 0;
    // 2. 当指针j指向不为零的元素时，交换i与j所指的元素，并且i向前移动一位
    while(j < nums.length){
      if(nums[j] != 0){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
        i++;
      }
      j++;
    }
    return nums;
  }
  public static void main(String[] args) {
    _02MoveZeroes method = new _02MoveZeroes();
    int[] nums = {0, 1, 0, 3, 12};
    System.out.println(Arrays.toString(method.moveZeroes(nums)));
  }
}
