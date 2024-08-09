package suanfa;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _14InorderTraversal {
  // 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    // 直接返回空列表，如果根节点为空
    if (root == null) {
      return result;
    }

    Stack<TreeNode> stack = new Stack<>();
    TreeNode currentNode = root;

    // 循环直到当前节点为空并且栈也为空
    while (currentNode != null || !stack.isEmpty()) {
      // 将左子树压入栈中
      while (currentNode != null) {
        stack.push(currentNode);
        currentNode = currentNode.left;
      }

      // 弹出栈顶元素，并将其值加入结果列表
      currentNode = stack.pop();
      result.add(currentNode.val);

      // 移动到右子树
      currentNode = currentNode.right;
    }
    return result;
  }

}
