/**
 * 给你一个整数 n ，
 * 求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数
 */
public class _63UniqueBinarySearchTrees {
  public int numTrees(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1; // 空树的情况
    dp[1] = 1; // 只有一个节点的情况

    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i] += dp[j - 1] * dp[i - j]; // 根据状态转移方程计算
      }
    }

    return dp[n];
  }
}

