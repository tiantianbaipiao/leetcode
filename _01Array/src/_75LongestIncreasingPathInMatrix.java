/**
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。
 * 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 */
public class _75LongestIncreasingPathInMatrix {

    private int rows;
    private int cols;
    private int[][] matrix;
    private int[][] memo;

    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};

    /**
     * 在给定的矩阵中找到最长递增路径的长度
     * @param matrix 给定的二维矩阵
     * @return 最长递增路径的长度
     */
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        cols = matrix[0].length;
        memo = new int[rows][cols];

        int maxLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxLength = Math.max(maxLength, dfs(i, j));
            }
        }

        return maxLength;
    }

    /**
     * 深度优先搜索 (DFS) 方法
     * @param x 当前行坐标
     * @param y 当前列坐标
     * @return 从当前位置开始的最长递增路径长度
     */
    private int dfs(int x, int y) {
        if (memo[x][y] != 0) {
            return memo[x][y];
        }

        int maxLen = 1;
        for (int k = 0; k < 4; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];

            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && matrix[newX][newY] > matrix[x][y]) {
                maxLen = Math.max(maxLen, 1 + dfs(newX, newY));
            }
        }

        memo[x][y] = maxLen;
        return maxLen;
    }

    public static void main(String[] args) {
        _75LongestIncreasingPathInMatrix solution = new _75LongestIncreasingPathInMatrix();

        // 测试数据
        int[][] matrix = {
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
        };

        // 输出结果
        System.out.println("Longest Increasing Path Length: " + solution.longestIncreasingPath(matrix));
    }
}


     