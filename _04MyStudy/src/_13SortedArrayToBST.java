/**
 *
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
 *
 * BST 的中序遍历是升序的，因此本题等同于根据中序遍历的序列恢复二叉搜索树。因此我们可以以升序序列中的任一个元素作为根节点，以该元素左边的升序序列
 * 构建左子树，以该元素右边的升序序列构建右子树，这样得到的树就是一棵二叉搜索树啦～ 又因为本题要求高度平衡，
 * 因此我们需要选择升序序列的中间元素作为根节点奥～
 *
 */
public class _13SortedArrayToBST {
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
  public TreeNode sortedArrayToBST(int[] nums) {
    return bfs(nums, 0, nums.length-1);
  }

  private TreeNode bfs(int[] nums, int left, int right) {
    if(left > right){
      return null;
    }
    int mid = (left + right)/2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = bfs(nums, left, mid - 1);
    root.right = bfs(nums,mid+1, right);
    return root;
  }
}
