package suanfa;

import utils.TreeNode;

public class _18MaxDepth {
  // 给定一个二叉树 root ，返回其最大深度。
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
}
