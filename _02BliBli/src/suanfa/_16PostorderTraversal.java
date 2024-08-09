package suanfa;

import javafx.util.Pair;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _16PostorderTraversal {
  // 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Stack<Pair<TreeNode, Boolean>> stack = new Stack<>();
    stack.push(new Pair<>(root, false));

    while (!stack.isEmpty()) {
      Pair<TreeNode, Boolean> pair = stack.peek();
      TreeNode node = pair.getKey();
      boolean visited = pair.getValue();

      if (visited) {
        // 已经访问过该节点，弹出并加入结果列表
        stack.pop();
        result.add(node.val);
      } else {
        // 标记为已访问
        stack.pop();
        stack.push(new Pair<>(node, true));

        // 先压入右节点，再压入左节点
        if (node.right != null) {
          stack.push(new Pair<>(node.right, false));
        }
        if (node.left != null) {
          stack.push(new Pair<>(node.left, false));
        }
      }
    }

    return result;
  }


}
