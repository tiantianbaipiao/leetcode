import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，
 * 那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 */
public class _91FindUnsortedSubarray {
  public int findUnsortedSubarray(int[] nums) {
    int[] sortedNums = nums.clone();  // 创建原始数组的一个副本
    Arrays.sort(sortedNums);  // 对副本进行排序

    int start = -1;
    int end = -1;

    // 寻找起始位置
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != sortedNums[i]) {
        start = i;
        break;
      }
    }

    // 寻找结束位置
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] != sortedNums[i]) {
        end = i;
        break;
      }
    }

    // 如果数组已经是有序的
    if (start == -1 && end == -1) {
      return 0;
    }

    return end - start + 1;  // 返回需要重排序的子数组的长度
  }

  public static void main(String[] args) {
    _91FindUnsortedSubarray solution = new _91FindUnsortedSubarray();
    int[] nums = {2, 6, 4, 8, 10, 9, 15};
    int result = solution.findUnsortedSubarray(nums);
    System.out.println("Result: " + result);  // 输出: 5
  }
}


