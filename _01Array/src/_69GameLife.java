/**
 * 生命游戏
 */
public class _69GameLife {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // 临时数组用于保存新状态
        int[][] tempBoard = new int[rows][cols];

        // 方向数组，用于遍历周围的8个位置
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };

        // 遍历每个位置
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = 0;

                // 计算周围8个位置的活细胞数量
                for (int[] direction : directions) {
                    int newRow = i + direction[0];
                    int newCol = j + direction[1];

                    // 检查边界
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && board[newRow][newCol] == 1) {
                        liveNeighbors++;
                    }
                }

                // 应用生命游戏规则
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    tempBoard[i][j] = 0; // 当前为活细胞，但周围活细胞数量不符合规则，变为死细胞
                } else if (board[i][j] == 0 && liveNeighbors == 3) {
                    tempBoard[i][j] = 1; // 当前为死细胞，周围有3个活细胞，变为活细胞
                } else {
                    tempBoard[i][j] = board[i][j]; // 状态不变
                }
            }
        }

        // 更新原数组
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = tempBoard[i][j];
            }
        }
    }

    public static void main(String[] args) {
        _69GameLife solution = new _69GameLife();
        int[][] board = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };

        solution.gameOfLife(board);

        // 打印更新后的数组
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
