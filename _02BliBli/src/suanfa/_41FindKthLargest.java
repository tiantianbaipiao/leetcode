package suanfa;

import java.util.PriorityQueue;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class _41FindKthLargest {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

    // Add first k elements to the min heap.
    for (int i = 0; i < k; i++) {
      minHeap.add(nums[i]);
    }

    // Iterate through the remaining elements of the array.
    for (int i = k; i < nums.length; i++) {
      // If the current element is larger than the smallest in the heap,
      // replace the smallest and re-heapify.
      if (nums[i] > minHeap.peek()) {
        minHeap.poll();
        minHeap.add(nums[i]);
      }
    }

    // The root of the heap is the kth largest element.
    return minHeap.peek();
  }
}

