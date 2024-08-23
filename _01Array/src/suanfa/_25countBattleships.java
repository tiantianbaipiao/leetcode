package suanfa;

/**
 * 给你一个大小为 m x n 的矩阵 board 表示棋盘，其中，每个单元格可以是一艘战舰 'X'
 * 或者是一个空位 '.' ，返回在棋盘 board 上放置的 舰队 的数量。
 */
public class _25countBattleships {
  public int countBattleships(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return 0;
    }

    int rows = board.length;
    int cols = board[0].length;
    int count = 0;

    // 遍历每个元素
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        // 如果当前元素为 '1' 并且它是战舰的头部，则计数器加一
        if (board[i][j] == 'X' && isHeadOfShip(board, i, j)) {
          count++;
        }
      }
    }

    return count;
  }

  // 辅助方法，检查一个位置是否是战舰的头部
  private boolean isHeadOfShip(char[][] board, int row, int col) {
    // 检查上方是否有 'X'
    if (row > 0 && board[row - 1][col] == 'X') {
      return false;
    }

    // 检查左侧是否有 'X'
    if (col > 0 && board[row][col - 1] == 'X') {
      return false;
    }

    // 如果既没有上方也没有左侧的 'X'，则是战舰的头部
    return true;
  }
}

