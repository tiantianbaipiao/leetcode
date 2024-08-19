package suanfa;

import utils.TreeNode;

/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和
 */
public class _95MaxPathSum {
  int maxSum = Integer.MIN_VALUE;  // 用于记录全局最大路径和

  public int maxPathSum(TreeNode root) {
    dfs(root);
    return maxSum;
  }

  private int dfs(TreeNode node) {
    if (node == null) {
      return 0;
    }

    // 递归计算左右子树的最大路径和
    int leftMax = Math.max(0, dfs(node.left));  // 左子树的最大贡献值
    int rightMax = Math.max(0, dfs(node.right));  // 右子树的最大贡献值

    // 更新全局最大路径和
    maxSum = Math.max(maxSum, node.val + leftMax + rightMax);

    // 返回以当前节点为起点的最大路径和
    return node.val + Math.max(leftMax, rightMax);
  }
  public static void main(String[] args) {
    _95MaxPathSum solution = new _95MaxPathSum();

    // 构建示例二叉树
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    int result = solution.maxPathSum(root);
    System.out.println("Result: " + result);  // 输出: 6
  }
}

