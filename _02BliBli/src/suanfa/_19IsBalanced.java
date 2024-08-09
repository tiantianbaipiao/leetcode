package suanfa;

import utils.TreeNode;

public class _19IsBalanced {
  // 给定一个二叉树，判断它是否是平衡二叉树
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
  }
  private int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
}
