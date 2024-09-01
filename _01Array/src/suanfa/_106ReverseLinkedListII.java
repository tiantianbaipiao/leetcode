package suanfa;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class _106ReverseLinkedListII {

    /**
     * 反转链表中的子区间 [m, n]
     *
     * @param head 链表头结点
     * @param m 子区间的起始位置
     * @param n 子区间的结束位置
     * @return 新的头结点
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // 找到反转区间的前一个节点 pre
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        
        // 找到反转区间的起始节点 start
        ListNode start = pre.next;
        ListNode curr = start;
        
        // 反转子区间 [m, n]
        for (int i = m; i < n; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = start;
            start = next;
        }
        
        // 连接反转后的链表
        pre.next = start;
        
        return dummy.next;
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

        // 反转区间 [2, 4]
        _106ReverseLinkedListII solution = new _106ReverseLinkedListII();
        ListNode newHead = solution.reverseBetween(head, 2, 4);

        // 打印反转后的链表
        ListNode curr = newHead;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
