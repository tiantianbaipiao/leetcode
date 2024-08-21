/**
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 */
public class _09FindMaxConsecutiveOnes {
  public int findMaxConsecutiveOnes(int[] nums) {
    int maxCount = 0; // 记录最大连续 1 的数量
    int currentCount = 0; // 当前连续 1 的数量

    for (int num : nums) {
      if (num == 1) {
        currentCount++; // 遇到 1，则当前连续计数加 1
        maxCount = Math.max(maxCount, currentCount); // 更新最大计数
      } else {
        currentCount = 0; // 遇到 0，重置当前连续计数
      }
    }

    return maxCount;
  }

  // 测试函数
  public static void main(String[] args) {
    _09FindMaxConsecutiveOnes solution = new _09FindMaxConsecutiveOnes();
    int[] testArray = {1, 1, 0, 1, 1, 1};
    System.out.println(solution.findMaxConsecutiveOnes(testArray)); // 应输出 3
  }
}

