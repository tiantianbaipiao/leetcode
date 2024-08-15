package suanfa;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class _66ConstructBinaryTreeFromPreorderAndInorderTraversal {
  Map<Integer, Integer> indexMap = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    int n = preorder.length;
    // 构建哈希映射，帮助我们快速定位根节点
    for (int i = 0; i < n; i++) {
      indexMap.put(inorder[i], i);
    }
    return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
  }

  private TreeNode myBuildTree(int[] preorder, int[] inorder, int inLeft, int inRight, int preStart, int preEnd) {
    if (inLeft > inRight) {
      return null;
    }

    // 前序遍历中的第一个节点就是根节点
    int preRoot = preStart;
    // 在中序遍历中定位根节点
    int inRoot = indexMap.get(preorder[preRoot]);

    // 先把根节点建立出来
    TreeNode root = new TreeNode(preorder[preRoot]);
    // 得到左子树中的节点数目
    int sizeLeftSubtree = inRoot - inLeft;
    // 递归地构造左子树，并连接到根节点
    // 先序遍历中「从 左边界+1 开始的 sizeLeftSubtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
    root.left = myBuildTree(preorder, inorder, inLeft, inRoot - 1, preRoot + 1, preRoot + sizeLeftSubtree);
    // 递归地构造右子树，并连接到根节点
    // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
    root.right = myBuildTree(preorder, inorder, inRoot + 1, inRight, preRoot + sizeLeftSubtree + 1, preEnd);

    return root;
  }
}


