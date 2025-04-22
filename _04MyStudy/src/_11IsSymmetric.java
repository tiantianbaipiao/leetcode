/**
 *
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 判断是否是对称二叉树
 *
 */
public class _11IsSymmetric {
  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
  // 判断root左右子树的值是否相等 比如左子树的值是否等于右子树右子树
  public boolean isSymmetric(TreeNode root) {
    if(root == null){
      return true;
    }
    return isMirror(root.left, root.right);
  }

  private boolean isMirror(TreeNode left, TreeNode right) {
    if (left == null && right == null){
      return true;
    }
    if(left == null || right == null){
      return false;
    }
    return left.val == right.val && isMirror(left.left,right.right) && isMirror(left.right, right.left);
  }
}
