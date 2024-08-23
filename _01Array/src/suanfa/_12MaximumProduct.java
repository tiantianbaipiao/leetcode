package suanfa; /**
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 */
import java.util.Arrays;

public class _12MaximumProduct {
  public int maximumProduct(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;

    // 比较最大的三个正数的乘积与最小的两个负数乘以最大的正数的乘积
    return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
  }

  // 测试函数
  public static void main(String[] args) {
    _12MaximumProduct solution = new _12MaximumProduct();
    int[] testArray = {1, 2, 3};
    System.out.println(solution.maximumProduct(testArray)); // 应输出 6
  }
}

