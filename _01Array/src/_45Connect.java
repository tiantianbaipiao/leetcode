import java.util.*;

/**
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */
// 定义二叉树节点类
class Node {
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

public class _45Connect {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        // 使用队列进行层次遍历
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            // 遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();

                // 如果不是当前层的最后一个节点，那么将其 next 指针指向队列中的下一个节点
                if (i < size - 1) {
                    currentNode.next = queue.peek();
                }

                // 将当前节点的左右子节点加入队列
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return root;
    }
}
