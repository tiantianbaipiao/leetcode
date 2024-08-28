import utils.ListNode;

/**
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，
 * 然后返回重新排序的列表。
 *
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推
 */
public class _74OddEvenList {
    /**
     * 将链表中的节点按奇偶顺序重新排列
     * @param head 链表的头节点
     * @return 重新排列后的链表头节点
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 定义奇数链表和偶数链表的头节点
        ListNode oddHead = head;
        ListNode evenHead = head.next;

        // 定义奇数链表和偶数链表的当前节点
        ListNode oddCurrent = oddHead;
        ListNode evenCurrent = evenHead;

        // 当前节点指向下一个奇数节点
        ListNode current = evenCurrent.next;

        // 循环遍历链表，将奇数节点和偶数节点分开
        while (current != null) {
            // 将当前节点添加到奇数链表
            oddCurrent.next = current;
            oddCurrent = current;

            // 移动到下一个偶数节点
            current = current.next;
            if (current != null) {
                // 将当前节点添加到偶数链表
                evenCurrent.next = current;
                evenCurrent = current;

                // 移动到下一个奇数节点
                current = current.next;
            }
        }

        // 将奇数链表和偶数链表连接起来
        oddCurrent.next = evenHead;
        evenCurrent.next = null;

        return oddHead;
    }
}
