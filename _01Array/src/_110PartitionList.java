/**
 * 给你一个链表的头节点 head 和一个特定值 x ，
 * 请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 */
public class _110PartitionList {

    /**
     * 分割链表
     *
     * @param head 链表头结点
     * @param x 分割值
     * @return 分割后的链表头结点
     */
    public ListNode partition(ListNode head, int x) {
        // 创建两个虚拟头节点
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        // 初始化指针
        ListNode lessCurrent = lessDummy;
        ListNode greaterCurrent = greaterDummy;
        ListNode current = head;

        // 遍历原链表
        while (current != null) {
            if (current.val < x) {
                // 小于 x 的节点加入 less 链表
                lessCurrent.next = current;
                lessCurrent = lessCurrent.next;
            } else {
                // 大于等于 x 的节点加入 greater 链表
                greaterCurrent.next = current;
                greaterCurrent = greaterCurrent.next;
            }
            current = current.next;
        }

        // 连接两个链表
        lessCurrent.next = greaterDummy.next;
        greaterCurrent.next = null; // 防止形成环

        return lessDummy.next;
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
        // 构建链表 1->4->3->2->5->2
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        // 分割链表
        _110PartitionList solution = new _110PartitionList();
        ListNode newHead = solution.partition(head, 3);

        // 打印分割后的链表
        ListNode curr = newHead;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");

        // 构建链表 2->1
        head = new ListNode(2);
        head.next = new ListNode(1);

        // 分割链表
        newHead = solution.partition(head, 2);

        // 打印分割后的链表
        curr = newHead;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
