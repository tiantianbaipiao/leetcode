public class _135MinimumTotal {

    /**
     * 在一个三角形数组中找到从顶部到底部的最小路径和
     * @param triangle 三角形数组
     * @return 最小路径和
     */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return 0;
        }

        int n = triangle.length;

        // 从倒数第二行开始，逐行向上更新
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // 更新当前元素为下面两个元素的较小值加上当前元素
                triangle[i][j] += Math.min(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }

        // 返回顶部元素的最小路径和
        return triangle[0][0];
    }
}
