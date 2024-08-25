package suanfa;

/**
 * 编写一个函数来修改给定的 m x n 的矩阵，
 * 如果矩阵中的某个元素为 0，则将其所在行和列的所有元素都设为 0。
 */
public class _42SetZeroes {
  public void setZeroes(int[][] matrix) {
    boolean firstRowHasZero = false, firstColHasZero = false;
    int rows = matrix.length, cols = matrix[0].length;

    // 检查第一行是否有0
    for (int j = 0; j < cols; j++) {
      if (matrix[0][j] == 0) {
        firstRowHasZero = true;
        break;
      }
    }

    // 检查第一列是否有0
    for (int i = 0; i < rows; i++) {
      if (matrix[i][0] == 0) {
        firstColHasZero = true;
        break;
      }
    }

    // 使用第一行和第一列作为标记
    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < cols; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0; // 标记该行
          matrix[0][j] = 0; // 标记该列
        }
      }
    }

    // 根据标记设置0
    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < cols; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    // 设置第一行和第一列
    if (firstRowHasZero) {
      for (int j = 0; j < cols; j++) {
        matrix[0][j] = 0;
      }
    }
    if (firstColHasZero) {
      for (int i = 0; i < rows; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}
