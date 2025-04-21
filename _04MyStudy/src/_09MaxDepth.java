/**
 *  给定一个二叉树 root ，返回其最大深度。
 *
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数
 */
public class _09MaxDepth {
  // Definition for a binary tree node.
  public static class TreeNode {
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
  // 二叉树的深度等于左右字数深度的最大值+1
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

  public static void main(String[] args) {
    _09MaxDepth solution = new _09MaxDepth();

    // 创建一个示例二叉树：
    //       1
    //      / \
    //     2   3
    //    / \
    //   4   5
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    // 计算并输出二叉树的最大深度
    int depth = solution.maxDepth(root);
    System.out.println("二叉树的最大深度是: " + depth);
  }
}
