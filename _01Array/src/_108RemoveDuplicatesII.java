/**
 * 给定一个已排序的链表的头 head ，
 * 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
public class _108RemoveDuplicatesII {

    /**
     * 删除排序链表中的重复元素 II
     *
     * @param head 链表头结点
     * @return 删除重复元素后的链表头结点
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // 初始化指针
        ListNode prev = dummy;
        ListNode curr = head;
        
        while (curr != null) {
            // 寻找重复元素的结尾
            ListNode nextDiff = curr.next;
            while (nextDiff != null && nextDiff.val == curr.val) {
                nextDiff = nextDiff.next;
            }
            
            // 如果有重复元素，则跳过这些元素
            if (nextDiff != curr.next) {
                prev.next = nextDiff;
                curr = nextDiff;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        
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
        // 构建链表 1->2->3->3->4->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        // 删除重复元素
        _108RemoveDuplicatesII solution = new _108RemoveDuplicatesII();
        ListNode newHead = solution.deleteDuplicates(head);

        // 打印删除重复元素后的链表
        ListNode curr = newHead;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");

        // 构建链表 1->1->1->2->3
        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);

        // 删除重复元素
        newHead = solution.deleteDuplicates(head);

        // 打印删除重复元素后的链表
        curr = newHead;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
