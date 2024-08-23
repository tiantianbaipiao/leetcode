import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class _28SpiralOrder {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return result;
    }

    int top = 0;
    int bottom = matrix.length - 1;
    int left = 0;
    int right = matrix[0].length - 1;

    while (top <= bottom && left <= right) {
      // 从左到右打印顶部的元素
      for (int i = left; i <= right; i++) {
        result.add(matrix[top][i]);
      }
      top++;

      // 从上到下打印右侧的元素
      for (int i = top; i <= bottom; i++) {
        result.add(matrix[i][right]);
      }
      right--;

      // 如果还有未访问的元素，则从右到左打印底部的元素
      if (top <= bottom) {
        for (int i = right; i >= left; i--) {
          result.add(matrix[bottom][i]);
        }
        bottom--;
      }

      // 如果还有未访问的元素，则从下到上打印左侧的元素
      if (left <= right) {
        for (int i = bottom; i >= top; i--) {
          result.add(matrix[i][left]);
        }
        left++;
      }
    }

    return result;
  }
}

