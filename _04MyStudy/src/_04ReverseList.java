/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 力扣 206
 */
public class _04ReverseList {
  // Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
   // 反转链表：双指针法
   public ListNode reverseList(ListNode head) {
    // 1. 定义当前指针cur 前指针prev 中间置换节点temp
     ListNode cur = head;
     ListNode prev = null;
     ListNode temp = null;
     // 2. 循环交换
     while (cur != null){
       // 保存下一个节点
     }
    return null;
   }
}
