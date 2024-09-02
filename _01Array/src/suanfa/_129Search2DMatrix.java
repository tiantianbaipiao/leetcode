package suanfa;

public class _129Search2DMatrix {

    /**
     * 在二维矩阵中搜索目标值
     * @param matrix 二维矩阵
     * @param target 目标值
     * @return 是否找到目标值
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false; // 矩阵为空或行列长度为零
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true; // 找到目标值
            } else if (matrix[row][col] > target) {
                col--; // 向左移动一列
            } else {
                row++; // 向下移动一行
            }
        }

        return false; // 未找到目标值
    }

    // 测试方法
    public static void main(String[] args) {
        _129Search2DMatrix solution = new _129Search2DMatrix();

        int[][] matrix1 = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int target1 = 5;
        System.out.println(solution.searchMatrix(matrix1, target1)); // 应输出 true

        int[][] matrix2 = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int target2 = 20;
        System.out.println(solution.searchMatrix(matrix2, target2)); // 应输出 false
    }
}
