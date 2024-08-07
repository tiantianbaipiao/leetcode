import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _15PreorderTraversal {
  // 给你一个二叉树的根节点 root ，返回它的前序遍历。
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    // 如果根节点为空，则直接返回空列表
    if (root == null) {
      return result;
    }

    Stack<TreeNode> stack = new Stack<>();
    TreeNode currentNode = root;

    // 循环直到当前节点为空并且栈也为空
    while (currentNode != null || !stack.isEmpty()) {
      // 当前节点不为空时，将其值添加到结果列表中
      while (currentNode != null) {
        result.add(currentNode.val);
        stack.push(currentNode);
        currentNode = currentNode.left;
      }

      // 弹出栈顶元素，并移动到其右子树
      currentNode = stack.pop();
      currentNode = currentNode.right;
    }

    return result;
  }
}
