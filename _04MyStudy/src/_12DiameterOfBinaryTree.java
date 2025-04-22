/**
 *
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 *
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 *
 * 两节点之间路径的 长度 由它们之间边数表示。
 * 一条路径的长度为该路径经过的节点数减一，所以求直径（即求路径长度的最大值）等效于求路径经过节点数的最大值减一。
 *
 * 链：从子树中的叶子节点到当前节点的路径。把最长链的长度，作为 dfs 的返回值。根据这一定义，空节点的链长是 −1，叶子节点的链长是 0。
 *
 */
public class _12DiameterOfBinaryTree {
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
  private int ans;
  public int diameterOfBinaryTree(TreeNode root) {
    dfs(root);
    return ans;
  }

  private int dfs(TreeNode node) {
    if (node == null) {
      return -1;
    }
    int lLen = dfs(node.left) + 1; // 左子树最大链长+1
    int rLen = dfs(node.right) + 1; // 右子树最大链长+1
    ans = Math.max(ans, lLen + rLen); // 两条链拼成路径
    return Math.max(lLen, rLen); // 当前子树最大链长
  }
}
