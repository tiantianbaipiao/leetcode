package suanfa;

import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class _93LargestRectangleArea {
  public int largestRectangleArea(int[] heights) {
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
    _93LargestRectangleArea solution = new _93LargestRectangleArea();
    int[] heights = {2, 1, 5, 6, 2, 3};
    int result = solution.largestRectangleArea(heights);
    System.out.println("Result: " + result);  // 输出: 10
  }
}

