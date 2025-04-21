/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 力扣 234 回文链表 往前读 往后读都是一样的
 * 1 - 2 - 2- 1
 *
 */
public class _05IsPalindrome {
  // Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  // 回文链表 快慢指针
  public boolean isPalindrome(ListNode head) {
    // 主要思想是将链表分为两部分 反转第二部分后再进行比较
    // 如果是空链表或者只有一个节点的链表都是回文链表
    if(head == null || head.next ==null){
      return true;
    }
    // 1. 快慢指针法找到需要反转的位置(慢指针slow走一步，快指针fast走两步)
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    // 2. 翻转后半部分链表
    ListNode temp = null;
    ListNode prev = null;
    while (slow != null){
      temp = slow.next;
      slow.next = prev;
      prev = slow;
      slow = temp;
    }
    // 3. 比较
    ListNode left = head;
    ListNode right = prev;
    while (right != null){
      if(left.val != right.val){
        return false;
      }
      left = left.next;
      right = right.next;
    }
    return true;
  }
}
