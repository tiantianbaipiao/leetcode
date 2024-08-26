/**
 * 力扣130
 */
public class _48Solve {
  public void solve(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return;
    }

    int rows = board.length;
    int cols = board[0].length;

    // 遍历第一行和最后一行
    for (int col = 0; col < cols; col++) {
      dfs(board, 0, col, rows, cols);
      dfs(board, rows - 1, col, rows, cols);
    }

    // 遍历第一列和最后一列
    for (int row = 0; row < rows; row++) {
      dfs(board, row, 0, rows, cols);
      dfs(board, row, cols - 1, rows, cols);
    }

    // 将 'A' 替换成 'O', 'O' 替换成 'X'
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (board[i][j] == 'A') {
          board[i][j] = 'O';
        } else if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
      }
    }
  }

  private void dfs(char[][] board, int row, int col, int rows, int cols) {
    if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != 'O') {
      return;
    }

    // 将访问过的 'O' 标记为 'A'
    board[row][col] = 'A';

    // 向四个方向递归
    dfs(board, row - 1, col, rows, cols); // 上
    dfs(board, row + 1, col, rows, cols); // 下
    dfs(board, row, col - 1, rows, cols); // 左
    dfs(board, row, col + 1, rows, cols); // 右
  }
}

