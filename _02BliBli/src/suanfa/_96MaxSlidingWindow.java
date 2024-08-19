package suanfa;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */
public class _96MaxSlidingWindow {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k <= 0) {
      return new int[0];
    }

    Deque<Integer> deque = new LinkedList<>();  // 双端队列
    int[] result = new int[nums.length - k + 1];  // 结果数组

    for (int i = 0; i < nums.length; i++) {
      // 移除队列中不在窗口内的元素
      while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
        deque.pollFirst();
      }

      // 保持队列非递减
      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.pollLast();
      }

      // 添加当前元素的索引
      deque.offerLast(i);

      // 当窗口大小达到 k 时，记录最大值
      if (i >= k - 1) {
        result[i - k + 1] = nums[deque.peekFirst()];
      }
    }

    return result;
  }

  public static void main(String[] args) {
    _96MaxSlidingWindow solution = new _96MaxSlidingWindow();
    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    int[] result = solution.maxSlidingWindow(nums, k);
    System.out.print("Result: ");
    for (int num : result) {
      System.out.print(num + " ");
    }
  }
}

