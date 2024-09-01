/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class _109RotateList {

    /**
     * 旋转链表
     *
     * @param head 链表头结点
     * @param k 旋转次数
     * @return 旋转后的链表头结点
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 计算链表长度
        int length = 1;
        ListNode current = head;
        while (current.next != null) {
            length++;
            current = current.next;
        }

        // 计算实际需要旋转的位置
        k %= length;
        if (k == 0) {
            return head;
        }

        // 将链表形成环
        current.next = head;

        // 找到新的头结点
        int stepsToNewHead = length - k;
        current = head;
        for (int i = 0; i < stepsToNewHead - 1; i++) {
            current = current.next;
        }

        // 断开并返回新的头结点
        ListNode newHead = current.next;
        current.next = null;

        return newHead;
    }

    // 链表节点定义
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        // 构建链表 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 旋转链表
        _109RotateList solution = new _109RotateList();
        ListNode newHead = solution.rotateRight(head, 2);

        // 打印旋转后的链表
        ListNode curr = newHead;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");

        // 构建链表 0->1->2
        head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        // 旋转链表
        newHead = solution.rotateRight(head, 4);

        // 打印旋转后的链表
        curr = newHead;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
