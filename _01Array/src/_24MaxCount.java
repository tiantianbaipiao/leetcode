/**
 * 给你一个 m x n 的矩阵 M 和一个操作数组 op 。
 * 矩阵初始化时所有的单元格都为 0 。ops[i] = [ai, bi]
 * 意味着当所有的 0 <= x < ai 和 0 <= y < bi 时， M[x][y] 应该加 1。
 *
 * 在 执行完所有操作后 ，计算并返回 矩阵中最大整数的个数 。
 */
public class _24MaxCount {
  public int maxCount(int m, int n, int[][] ops) {
    // 初始化矩阵的最大宽度和高度
    int maxWidth = n;
    int maxHeight = m;

    // 遍历每个操作
    for (int[] op : ops) {
      // 更新最大宽度和高度
      maxWidth = Math.min(maxWidth, op[1]);
      maxHeight = Math.min(maxHeight, op[0]);
    }

    // 计算最大整数出现的次数
    return maxWidth * maxHeight;
  }
}

