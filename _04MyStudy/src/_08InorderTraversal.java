import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * 左根右
 */
public class _08InorderTraversal {
  // Definition for a binary tree node.
  public static class TreeNode {
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
  public List<Integer> inorderTraversal(TreeNode root) {
    // 定义一个结果列表用于返回最后的排序结果
    List<Integer> res = new ArrayList<>();
    // 定义一个节点表示当前节点并指向根节点
    TreeNode currentNode = root;
    // 定义一个栈用于弹出栈顶元素
    Stack<TreeNode> stack = new Stack<>();
    // 循环退出条件是currentNode等于空 或者 栈为空
    while (currentNode != null || !stack.isEmpty()){
      // 首先把左子树压入栈中
      while (currentNode!=null){
        stack.push(currentNode);
        currentNode = currentNode.left;
      }

      // 弹出栈顶元素
      currentNode = stack.pop();
      res.add(currentNode.val);

      //再把右子树压入栈中
      currentNode = currentNode.right;
    }
    return res;
  }

  public static void main(String[] args) {
    _08InorderTraversal solution = new _08InorderTraversal();

    // 构造示例二叉树：1 -> 2 -> 4, 1 -> 3 -> null
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    // 执行中序遍历
    List<Integer> result = solution.inorderTraversal(root);

    // 打印结果
    System.out.println("中序遍历结果: " + result);
  }
}
