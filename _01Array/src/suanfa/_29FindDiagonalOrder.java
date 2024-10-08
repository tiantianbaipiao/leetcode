package suanfa;

/**
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素
 */
public class _29FindDiagonalOrder {
  public int[] findDiagonalOrder(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    int[] res = new int[m * n];
    int pos = 0;
    for (int i = 0; i < m + n - 1; i++) {
      if (i % 2 == 1) {
        int x = i < n ? 0 : i - n + 1;
        int y = i < n ? i : n - 1;
        while (x < m && y >= 0) {
          res[pos] = mat[x][y];
          pos++;
          x++;
          y--;
        }
      } else {
        int x = i < m ? i : m - 1;
        int y = i < m ? 0 : i - m + 1;
        while (x >= 0 && y < n) {
          res[pos] = mat[x][y];
          pos++;
          x--;
          y++;
        }
      }
    }
    return res;
  }
}


