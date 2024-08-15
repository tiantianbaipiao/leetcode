package suanfa;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用
 */
public class _62WordSearch {
  public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0 || word == null || word.isEmpty()) return false;

    int rows = board.length;
    int cols = board[0].length;

    boolean[][] visited = new boolean[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (searchWord(board, word, 0, i, j, visited)) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean searchWord(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
    if (index == word.length()) return true; // 找到所有字母

    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
        visited[row][col] || board[row][col] != word.charAt(index)) {
      return false;
    }

    visited[row][col] = true;
    boolean found =
        searchWord(board, word, index + 1, row - 1, col, visited) || // 上
            searchWord(board, word, index + 1, row + 1, col, visited) || // 下
            searchWord(board, word, index + 1, row, col - 1, visited) || // 左
            searchWord(board, word, index + 1, row, col + 1, visited); // 右
    visited[row][col] = false;

    return found;
  }
}

