package suanfa;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _141MaxProfit {

    /**
     * 在一场 IPO 中选择一些项目进行投资，使得总利润最大化。
     *
     * @param k      最多可以选择的项目数量
     * @param w      初始资本
     * @param profits 每个项目的利润
     * @param capital 每个项目的成本
     * @return 最大化后的总利润
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int curr = 0;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; ++i) {
            while (curr < n && arr[curr][0] <= w) {
                pq.add(arr[curr][1]);
                curr++;
            }
            if (!pq.isEmpty()) {
                w += pq.poll();
            } else {
                break;
            }
        }

        return w;
    }

    public static void main(String[] args) {
        _141MaxProfit solution = new _141MaxProfit();

        // 测试用例
        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};
        System.out.println(solution.findMaximizedCapital(k, w, profits, capital)); // 输出应为 4

        k = 3;
        w = 0;
        profits = new int[]{1, 2, 3};
        capital = new int[]{0, 1, 2};
        System.out.println(solution.findMaximizedCapital(k, w, profits, capital)); // 输出应为 6

        k = 2;
        w = 0;
        profits = new int[]{1, 2, 3};
        capital = new int[]{1, 1, 2};
        System.out.println(solution.findMaximizedCapital(k, w, profits, capital)); // 输出应为 5
    }
}
