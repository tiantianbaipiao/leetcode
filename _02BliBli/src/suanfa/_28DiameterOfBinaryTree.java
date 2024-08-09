package suanfa;

import utils.TreeNode;

/**
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 *
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 *
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class _28DiameterOfBinaryTree {
  private int diameter = 0;
  /**
   * 计算二叉树的直径。
   *
   * @param root 树的根节点
   * @return 树的直径
   */
  public int diameterOfBinaryTree(TreeNode root) {
    depth(root);
    return diameter;
  }

  /**
   * 计算以当前节点为根的子树的最大深度，并更新直径。
   *
   * @param node 当前节点
   * @return 子树的最大深度
   */
  private int depth(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftDepth = depth(node.left);
    int rightDepth = depth(node.right);

    // 更新直径
    diameter = Math.max(diameter, leftDepth + rightDepth);

    // 返回当前节点的最大深度
    return Math.max(leftDepth, rightDepth) + 1;
  }

}

