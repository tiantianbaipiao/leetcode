public class _107ReverseKGroup {

    /**
     * K个一组翻转链表
     *
     * @param head 链表头结点
     * @param k 翻转的组大小
     * @return 新的头结点
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 初始化指针
        ListNode pre = dummy;
        ListNode end = dummy;

        while (true) {
            // 找到当前组的结尾
            for (int i = 0; i < k; ++i) {
                if (end == null) {
                    return dummy.next;
                }
                end = end.next;
            }

            // 找到下一组的开始
            ListNode next = end.next;

            // 翻转当前组
            ListNode start = pre.next;
            pre.next = reverse(start, end);

            // 更新指针
            pre = start;
            end = next;
        }
    }

    /**
     * 翻转从 start 到 end 的链表
     *
     * @param start 开始节点
     * @param end 结束节点
     * @return 翻转后的头结点
     */
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode curr = start;

        while (curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 连接翻转后的链表
        start.next = end;
        return prev;
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

        // 翻转每 2 个节点
        _107ReverseKGroup solution = new _107ReverseKGroup();
        ListNode newHead = solution.reverseKGroup(head, 2);

        // 打印翻转后的链表
        ListNode curr = newHead;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");

        // 翻转每 3 个节点
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        newHead = solution.reverseKGroup(head, 3);

        // 打印翻转后的链表
        curr = newHead;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
