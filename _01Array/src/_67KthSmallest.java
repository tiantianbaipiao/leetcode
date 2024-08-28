import utils.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉搜索树的根节点 root ，
 * 和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 */
public class _67KthSmallest {
  public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;

    // 循环直到栈为空或当前节点为空
    while (current != null || !stack.isEmpty()) {
      // 一直向左走，并将经过的节点都压入栈中
      while (current != null) {
        stack.push(current);
        current = current.left;
      }

      // 当前节点为空时，从栈中弹出一个节点
      current = stack.pop();

      // 计数器加一
      k--;

      // 如果计数器为0，说明找到了第K小的元素
      if (k == 0) {
        return current.val;
      }

      // 继续向右子树移动
      current = current.right;
    }

    // 如果没有找到第K小的元素，抛出异常
    throw new IllegalArgumentException("Invalid input or K is out of bounds.");
  }
}

