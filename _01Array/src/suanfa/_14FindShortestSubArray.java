package suanfa;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度
 */
public class _14FindShortestSubArray {
  public int findShortestSubArray(int[] nums) {
    Map<Integer, int[]> map = new HashMap<>();
    int maxFreq = 0;

    // Populate the map with first index, last index, and frequency.
    for (int i = 0; i < nums.length; i++) {
      if (!map.containsKey(nums[i])) {
        map.put(nums[i], new int[]{i, i, 1}); // [firstIndex, lastIndex, freq]
      } else {
        int[] info = map.get(nums[i]);
        info[1] = i; // Update lastIndex
        info[2]++; // Increase frequency
        maxFreq = Math.max(maxFreq, info[2]);
      }
    }

    int minLen = Integer.MAX_VALUE;
    boolean found = false; // Flag to check if we've found a valid element

    // Find the shortest subarray length that meets the maxFreq condition.
    for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
      int[] info = entry.getValue();
      if (info[2] == maxFreq) { // Check if the current element's frequency is equal to maxFreq
        int len = info[1] - info[0] + 1; // Calculate the length
        if (!found || len < minLen) { // Set minLen only if it's the first time or a shorter length is found
          minLen = len;
          found = true;
        }
      }
    }

    // If no valid element was found, return 0 as per the problem statement.
    return found ? minLen : 1;
  }
}


