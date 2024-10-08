package suanfa;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，
 * 返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class _65BinaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> currentLevel = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        TreeNode currentNode = queue.poll();
        currentLevel.add(currentNode.val);

        if (currentNode.left != null) {
          queue.offer(currentNode.left);
        }
        if (currentNode.right != null) {
          queue.offer(currentNode.right);
        }
      }

      result.add(currentLevel);
    }

    return result;
  }
}


