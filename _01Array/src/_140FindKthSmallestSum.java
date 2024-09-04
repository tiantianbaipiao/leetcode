import java.util.PriorityQueue;

public class _140FindKthSmallestSum {

    /**
     * 找到两个有序数组中的第k个最小的数对和。
     *
     * @param nums1 第一个有序数组
     * @param nums2 第二个有序数组
     * @param k     要找的第k个最小的数对和
     * @return 第k个最小的数对和
     */
    public int kthSmallestSum(int[] nums1, int[] nums2, int k) {
        // 使用优先队列（小顶堆）来存储数对和及其对应的索引
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // 将第一个数对加入优先队列
        pq.offer(new int[]{nums1[0] + nums2[0], 0, 0});

        // 标记已访问过的数对
        boolean[][] visited = new boolean[nums1.length][nums2.length];
        visited[0][0] = true;

        // 遍历k次，每次取出最小的数对
        int[] curr = new int[0];
        for (int i = 0; i < k; i++) {
            curr = pq.poll();
            int row = curr[1];
            int col = curr[2];

            // 向右移动
            if (col + 1 < nums2.length && !visited[row][col + 1]) {
                pq.offer(new int[]{nums1[row] + nums2[col + 1], row, col + 1});
                visited[row][col + 1] = true;
            }

            // 向下移动
            if (row + 1 < nums1.length && !visited[row + 1][col]) {
                pq.offer(new int[]{nums1[row + 1] + nums2[col], row + 1, col});
                visited[row + 1][col] = true;
            }
        }

        // 返回第k个最小的数对和
        return curr[0];
    }

    public static void main(String[] args) {
        _140FindKthSmallestSum solution = new _140FindKthSmallestSum();

        // 测试用例
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        System.out.println(solution.kthSmallestSum(nums1, nums2, k)); // 输出应为8

        nums1 = new int[]{1, 1, 2};
        nums2 = new int[]{1, 2, 3};
        k = 2;
        System.out.println(solution.kthSmallestSum(nums1, nums2, k)); // 输出应为2

        nums1 = new int[]{1, 2};
        nums2 = new int[]{-3, 4};
        k = 4;
        System.out.println(solution.kthSmallestSum(nums1, nums2, k)); // 输出应为2
    }
}
