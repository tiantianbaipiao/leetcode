package suanfa;

import utils.TreeNode;

import java.util.Stack;

/**
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 */
class ConvertBST {
  private int sum = 0;  // 用于累加的变量

  public TreeNode convertBST(TreeNode root) {
    // 使用迭代方法进行后序遍历
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;

    while (!stack.isEmpty() || current != null) {
      // 先遍历到最右边的节点
      while (current != null) {
        stack.push(current);
        current = current.right;
      }

      // 处理当前节点
      current = stack.pop();
      sum += current.val;  // 累加当前节点的值
      current.val = sum;   // 更新节点值

      // 接着遍历左子树
      current = current.left;
    }

    return root;
  }

  public static void main(String[] args) {
    // 构建二叉搜索树
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(13);

    ConvertBST solution = new ConvertBST();
    TreeNode convertedRoot = solution.convertBST(root);

    // 打印转换后的二叉树
    printTree(convertedRoot);
  }

  private static void printTree(TreeNode root) {
    if (root != null) {
      printTree(root.left);
      System.out.print(root.val + " ");
      printTree(root.right);
    }
  }
}

