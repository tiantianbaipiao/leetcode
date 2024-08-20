package suanfa;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class _103Trap {

  // 接雨水
  public int trap(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    int n = height.length;
    int[] leftMax = new int[n];
    int[] rightMax = new int[n];
    int water = 0;

    // 计算左侧最大高度
    leftMax[0] = height[0];
    for (int i = 1; i < n; i++) {
      leftMax[i] = Math.max(leftMax[i - 1], height[i]);
    }

    // 计算右侧最大高度
    rightMax[n - 1] = height[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      rightMax[i] = Math.max(rightMax[i + 1], height[i]);
    }

    // 计算可以接的雨水量
    for (int i = 0; i < n; i++) {
      water += Math.min(leftMax[i], rightMax[i]) - height[i];
    }

    return water;
  }

  public static void main(String[] args) {
    _103Trap solution = new _103Trap();
    int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int trappedWater = solution.trap(height);
    System.out.println("Trapped Water: " + trappedWater);
  }
}

