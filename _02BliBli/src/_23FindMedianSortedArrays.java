public class _23FindMedianSortedArrays {
  // 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
  //算法的时间复杂度应该为 O(log (m+n)) 。
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      // 确保 nums1 是较短的那个数组
      return findMedianSortedArrays(nums2, nums1);
    }

    int x = nums1.length;
    int y = nums2.length;
    int low = 0;
    int high = x;

    while (low <= high) {
      int partitionX = (low + high) / 2;
      int partitionY = (x + y + 1) / 2 - partitionX;

      // 如果 partitionX 为 0，意味着没有什么元素被放在左边
      // 如果 partitionX 为 x，则意味着所有元素都被放在左边
      // 分割 nums1 的元素
      int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
      int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

      // 分割 nums2 的元素
      int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
      int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

      if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
        // 我们找到了正确的分割
        if ((x + y) % 2 == 0) {
          return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
        } else {
          return (double)Math.max(maxLeftX, maxLeftY);
        }
      } else if (maxLeftX > minRightY) { // 缩小 nums1 的搜索范围
        high = partitionX - 1;
      } else { // 扩大 nums1 的搜索范围
        low = partitionX + 1;
      }
    }

    throw new IllegalArgumentException("Input arrays are not sorted!");
  }

}

