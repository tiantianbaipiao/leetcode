import utils.TreeNode;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左
 * 子树
 * 只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class _64ValidateBinarySearchTree {
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean isValidBST(TreeNode node, long min, long max) {
    if (node == null) {
      return true;
    }

    if (node.val <= min || node.val >= max) {
      return false;
    }

    return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
  }
}

