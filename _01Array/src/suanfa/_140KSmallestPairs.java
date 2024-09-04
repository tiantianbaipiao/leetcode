package suanfa;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _140KSmallestPairs {

    /**
     * 找到两个非递减有序数组中和最小的 k 个数对。
     *
     * @param nums1 第一个非递减有序数组
     * @param nums2 第二个非递减有序数组
     * @param k     要找的最小的 k 个数对
     * @return 和最小的 k 个数对
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        // 使用优先队列（小顶堆）来存储数对和及其对应的索引
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // 将第一个数对加入优先队列
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        // 遍历k次，每次取出最小的数对
        while (!pq.isEmpty() && result.size() < k) {
            int[] curr = pq.poll();
            int sum = curr[0];
            int row = curr[1];
            int col = curr[2];

            // 添加当前数对到结果列表
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[row]);
            pair.add(nums2[col]);
            result.add(pair);

            // 向右移动
            if (col + 1 < nums2.length) {
                pq.offer(new int[]{nums1[row] + nums2[col + 1], row, col + 1});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        _140KSmallestPairs solution = new _140KSmallestPairs();

        // 测试用例
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        System.out.println(solution.kSmallestPairs(nums1, nums2, k)); // 输出应为 [[1, 2], [1, 4], [1, 6]]

        nums1 = new int[]{1, 1, 2};
        nums2 = new int[]{1, 2, 3};
        k = 2;
        System.out.println(solution.kSmallestPairs(nums1, nums2, k)); // 输出应为 [[1, 1], [1, 1]]

        nums1 = new int[]{1, 2};
        nums2 = new int[]{-3, 4};
        k = 4;
        System.out.println(solution.kSmallestPairs(nums1, nums2, k)); // 输出应为 [[1, -3], [1, 4], [2, -3], [2, 4]]
    }
}
