package suanfa;

import java.util.Arrays;

/**
 * 最小移动次数使数组元素相等 要求我们计算最少需要多少次操作使得数组中的所有元素相等，
 * 其中每次操作可以选择任意一个元素并将其增加或减少 1。
 */
public class _20MinMoves {
  public int minMoves(int[] nums) {
    // 首先对数组进行排序
    Arrays.sort(nums);

    // 找到数组中的最小值
    int minValue = nums[0];

    // 初始化移动次数为 0
    int moves = 0;

    // 遍历数组中的每个元素
    for (int num : nums) {
      // 计算当前元素与最小值之间的差值
      int diff = num - minValue;

      // 移动次数加上差值
      moves += diff;
    }

    // 返回计算得到的移动次数
    return moves;
  }
}



