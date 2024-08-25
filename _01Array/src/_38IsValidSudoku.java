import java.util.HashSet;
import java.util.Set;

/**
 * 实现有效的数独验证（Valid Sudoku）要求我们编写一个函数来检查给定的 9x9 的数独板是否有效。
 * 数独板的有效性是指每一行、每一列以及每一个 3x3 的宫格内的数字都不重复
 */
public class _38IsValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    Set<String> seen = new HashSet<>(); // 使用 HashSet 来记录已见过的元素

    // 遍历数独板
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char number = board[i][j];
        if (number != '.') { // 只检查非空格
          // 构造唯一的标识符
          String row = number + " in row " + i;
          String col = number + " in col " + j;
          String box = number + " in box " + i / 3 + "-" + j / 3;

          // 检查是否已经出现过
          if (seen.contains(row) || seen.contains(col) || seen.contains(box)) {
            return false; // 发现重复，返回 false
          }

          // 添加到已见过的集合中
          seen.add(row);
          seen.add(col);
          seen.add(box);
        }
      }
    }

    return true; // 所有检查通过，返回 true
  }
}
