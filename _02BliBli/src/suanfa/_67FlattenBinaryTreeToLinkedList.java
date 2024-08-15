package suanfa;

import utils.TreeNode;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class _67FlattenBinaryTreeToLinkedList {
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }

    flatten(root.left);
    flatten(root.right);

    // 保存右子树
    TreeNode right = root.right;

    // 将左子树移动到右子树的位置
    root.right = root.left;
    root.left = null;

    // 连接原右子树到左子树的末端
    TreeNode p = root;
    while (p.right != null) {
      p = p.right;
    }
    p.right = right;
  }
}

