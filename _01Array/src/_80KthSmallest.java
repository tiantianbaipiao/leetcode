import java.util.PriorityQueue;

/**
 * 给定一个 n x n 的二维矩阵 matrix，按照行优先顺序排序，返回矩阵中第 k 小的元素。
 */
public class _80KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // 将第一行的所有元素加入最小堆
        for (int j = 0; j < n; j++) {
            minHeap.offer(new int[]{matrix[0][j], 0, j});
        }

        // 提取 k-1 个最小元素
        while (k-- > 1) {
            int[] current = minHeap.poll();

            // 如果当前元素不是最后一行
            if (current[1] + 1 < n) {
                int nextRow = current[1] + 1;
                int nextCol = current[2];
                minHeap.offer(new int[]{matrix[nextRow][nextCol], nextRow, nextCol});
            }
        }

        // 返回第 k 个最小元素
        return minHeap.peek()[0];
    }
}
