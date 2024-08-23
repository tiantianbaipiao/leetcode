/**
 * 图像平滑器 是大小为 3 x 3 的过滤器，用于对图像的每个单元格平滑处理，
 * 平滑处理后单元格的值为该单元格的平均灰度。
 */
import java.util.Arrays;

public class _23ImageSmoother {
  public int[][] imageSmoother(int[][] M) {
    if (M == null || M.length == 0 || M[0].length == 0) {
      return new int[0][0];
    }

    int rows = M.length;
    int cols = M[0].length;
    int[][] result = new int[rows][cols];

    // 遍历每个元素
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        // 初始化计数器和累加器
        int count = 0;
        int sum = 0;

        // 遍历周围的 8 个邻居元素
        for (int x = Math.max(0, i - 1); x <= Math.min(rows - 1, i + 1); x++) {
          for (int y = Math.max(0, j - 1); y <= Math.min(cols - 1, j + 1); y++) {
            sum += M[x][y];
            count++;
          }
        }

        // 计算平均值
        result[i][j] = sum / count;
      }
    }

    return result;
  }
}

