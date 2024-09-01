package suanfa;

import java.util.LinkedList;
import java.util.Queue;

public class _113PopulatingNextRightPointers {

    /**
     * 填充每个节点的下一个右侧节点指针
     *
     * @param root 树的根节点
     * @return 填充后的树的根节点
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        // 广度优先搜索
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null; // 记录前一个节点

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                // 将当前节点的 next 指针指向 prev 节点的下一个节点
                if (prev != null) {
                    prev.next = current;
                }
                prev = current;

                // 将左右子节点加入队列
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            // 最后一个节点的 next 指针设置为 null
            prev.next = null;
        }

        return root;
    }

    // 定义二叉树节点
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args) {
        // 构建二叉树
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        // 填充 next 指针
        _113PopulatingNextRightPointers solution = new _113PopulatingNextRightPointers();
        Node connectedRoot = solution.connect(root);

        // 打印填充后的二叉树
        printTree(connectedRoot);
    }

    private static void printTree(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        if (node.next != null) {
            System.out.print("-> " + node.next.val);
        }
        System.out.println();
        printTree(node.left);
        printTree(node.right);
    }
}
