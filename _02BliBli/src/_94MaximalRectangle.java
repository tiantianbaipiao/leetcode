import java.util.Stack;

/**
 * 给定一个仅包含 0 和 1 、
 * 大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 */
public class _94MaximalRectangle {
  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int m = matrix.length;
    int n = matrix[0].length;
    int[] heights = new int[n];  // 动态规划数组，记录每列连续 1 的个数
    int maxArea = 0;  // 最大矩形面积

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        // 更新 heights 数组
        heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
      }

      // 应用柱状图中最大矩形面积的方法
      maxArea = Math.max(maxArea, largestRectangleArea(heights));
    }

    return maxArea;
  }

  private int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;  // 最大矩形面积
    int n = heights.length;

    for (int i = 0; i <= n; i++) {
      while (!stack.isEmpty() && (i == n || heights[stack.peek()] > heights[i])) {
        int height = heights[stack.pop()];  // 当前柱子高度
        int width = stack.isEmpty() ? i : i - stack.peek() - 1;  // 计算宽度
        maxArea = Math.max(maxArea, height * width);  // 更新最大面积
      }
      stack.push(i);  // 将当前柱子的索引压入栈
    }

    return maxArea;
  }

  public static void main(String[] args) {
    _94MaximalRectangle solution = new _94MaximalRectangle();
    char[][] matrix = {
        {'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'}
    };
    int result = solution.maximalRectangle(matrix);
    System.out.println("Result: " + result);  // 输出: 6
  }
}

