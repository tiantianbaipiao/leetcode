package suanfa;

import utils.TreeNode;
/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵
 * 平衡
 *  二叉搜索树。
 */
public class _07SortedArrayToBST {

  // 将有序数组转换为二叉搜索树
  public TreeNode sortedArrayToBST(int[] nums) {
    return buildBST(nums, 0, nums.length - 1);
  }

  private TreeNode buildBST(int[] nums, int start, int end) {
    if (start > end) return null;

    int mid = start + (end - start) / 2;
    TreeNode root = new TreeNode(nums[mid]);

    root.left = buildBST(nums, start, mid - 1);
    root.right = buildBST(nums, mid + 1, end);

    return root;
  }

  public static void main(String[] args) {
    _07SortedArrayToBST solution = new _07SortedArrayToBST();
    int[] nums = {-10, -3, 0, 5, 9};
    TreeNode root = solution.sortedArrayToBST(nums);
    printInOrder(root);
  }

  // 辅助函数：打印二叉树的中序遍历
  public static void printInOrder(TreeNode root) {
    if (root == null) return;
    printInOrder(root.left);
    System.out.print(root.val + " ");
    printInOrder(root.right);
  }
}

