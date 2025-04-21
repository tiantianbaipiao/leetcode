/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 力扣141 环形链表
 */
public class _06HasCycle {
  // Definition for singly-linked list.
  public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
      val = x;
      next = null;
    }
  }
  // 判断链表中是否有环，可以使用快慢指针法
  public boolean hasCycle(ListNode head) {
    // 空节点链表和只有一个节点的链表不存在环
    if(head == null || head.next == null){
      return false;
    }
    // 定义快慢指针
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != fast){
      if(fast == null || fast.next == null){
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return true;
  }
}
