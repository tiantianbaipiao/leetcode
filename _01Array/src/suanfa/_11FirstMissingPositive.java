package suanfa;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
public class _11FirstMissingPositive {
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;

    // 先将所有负数和大于 n 的数设为 n+1
    for (int i = 0; i < n; ++i) {
      if (nums[i] <= 0 || nums[i] > n) {
        nums[i] = n + 1;
      }
    }

    // 使用索引作为哈希来记录每个数字是否出现过
    for (int i = 0; i < n; ++i) {
      int num = Math.abs(nums[i]);
      if (num <= n) {
        nums[num - 1] = -Math.abs(nums[num - 1]);
      }
    }

    // 找到第一个正数的索引
    for (int i = 0; i < n; ++i) {
      if (nums[i] > 0) {
        return i + 1;
      }
    }

    // 如果全都是正数，说明从 1 到 n 都出现了，则答案是 n+1
    return n + 1;
  }

  // 测试函数
  public static void main(String[] args) {
    _11FirstMissingPositive solution = new _11FirstMissingPositive();
    int[] testArray = {1, 2, 0};
    System.out.println(solution.firstMissingPositive(testArray)); // 应输出 3
  }
}

