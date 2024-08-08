import utils.TreeNode;

public class _17IsSymmetric {
  // 给你一个二叉树的根节点 root ， 检查它是否轴对称。
  // Method to check if the tree is symmetric
    public boolean isSymmetric(TreeNode root) {
      if (root == null) {
        return true; // An empty tree is symmetric.
      }
      return checkSymmetry(root.left, root.right);
    }

    private boolean checkSymmetry(TreeNode leftNode, TreeNode rightNode) {
      if (leftNode == null && rightNode == null) return true;
      if (leftNode == null || rightNode == null) return false;
      return (leftNode.val == rightNode.val)
          && checkSymmetry(leftNode.left, rightNode.right)
          && checkSymmetry(leftNode.right, rightNode.left);
    }
}
