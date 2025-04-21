/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 力扣 226
 */
public class _10invertTree {
  // 定义一个数节点
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

   // 递归 交换左右子树
  public TreeNode invertTree(TreeNode root){
     // 如果是空节点则返回null
    if(root == null){
      return null;
    }
    // 用一个中间节点来进行交换
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    // 递归左右子树
    invertTree(root.left);
    invertTree(root.right);
     return root;
  }
}
