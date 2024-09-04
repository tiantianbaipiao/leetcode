package suanfa;

import java.util.List;

public class _135MinimumTotal {

    /**
     * 在一个三角形数组中找到从顶部到底部的最小路径和
     * @param triangle 三角形数组
     * @return 最小路径和
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }

        int n = triangle.size();

        // 从倒数第二行开始，逐行向上更新
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> currentRow = triangle.get(i);
            List<Integer> nextRow = triangle.get(i + 1);

            for (int j = 0; j <= i; j++) {
                // 更新当前元素为下面两个元素的较小值加上当前元素
                int minSum = Math.min(nextRow.get(j), nextRow.get(j + 1));
                currentRow.set(j, currentRow.get(j) + minSum);
            }
        }

        // 返回顶部元素的最小路径和
        return triangle.get(0).get(0);
    }
}
