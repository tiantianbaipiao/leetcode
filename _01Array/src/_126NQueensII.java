import java.util.HashSet;
import java.util.Set;

public class _126NQueensII {

    /**
     * 计算 N 皇后问题的解的数量
     * @param n 棋盘大小
     * @return 解的数量
     */
    public int totalNQueens(int n) {
        return backtrack(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    /**
     * 回溯算法生成解的数量
     * @param n 棋盘大小
     * @param row 当前行
     * @param cols 已经放置的皇后所在的列
     * @param diag1 主对角线上的位置
     * @param diag2 副对角线上的位置
     * @return 解的数量
     */
    private int backtrack(int n, int row, Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2) {
        if (row == n) {
            return 1; // 已经到达最后一行，返回 1
        }

        int count = 0;
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) {
                continue; // 当前列或对角线上已经有皇后，跳过
            }

            cols.add(col); // 放置皇后
            diag1.add(row - col);
            diag2.add(row + col);

            count += backtrack(n, row + 1, cols, diag1, diag2); // 递归到下一行

            cols.remove(col); // 回溯，取消放置皇后
            diag1.remove(row - col);
            diag2.remove(row + col);
        }

        return count;
    }

    // 测试方法
    public static void main(String[] args) {
        _126NQueensII solver = new _126NQueensII();
        int result = solver.totalNQueens(4);
        System.out.println(result); // 应输出 2
    }
}
