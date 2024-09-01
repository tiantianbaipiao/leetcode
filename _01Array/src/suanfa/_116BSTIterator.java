package suanfa;

import java.util.Stack;

/**
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 */
public class _116BSTIterator {

    private Stack<TreeNode> stack;

    public _116BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeftNodes(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        pushLeftNodes(node.right); // 将右子树的左节点压入栈
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeftNodes(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    // 二叉树节点定义
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        // 构建二叉搜索树
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        // 创建迭代器
        _116BSTIterator iterator = new _116BSTIterator(root);

        // 测试迭代器
        System.out.println(iterator.next()); // 输出 3
        System.out.println(iterator.next()); // 输出 7
        System.out.println(iterator.hasNext()); // 输出 true
        System.out.println(iterator.next()); // 输出 9
        System.out.println(iterator.hasNext()); // 输出 true
        System.out.println(iterator.next()); // 输出 15
        System.out.println(iterator.hasNext()); // 输出 true
        System.out.println(iterator.next()); // 输出 20
        System.out.println(iterator.hasNext()); // 输出 false
    }
}
