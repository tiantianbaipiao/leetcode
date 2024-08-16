import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class _68LongestConsecutive {
  public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num);
    }

    int maxLen = 0;
    for (int num : numSet) {
      // 只有当 num 是潜在连续序列的起点时才进行检查
      if (!numSet.contains(num - 1)) {
        int currentNum = num;
        int currentStreak = 1;

        while (numSet.contains(currentNum + 1)) {
          currentNum += 1;
          currentStreak += 1;
        }

        maxLen = Math.max(maxLen, currentStreak);
      }
    }

    return maxLen;
  }
}

