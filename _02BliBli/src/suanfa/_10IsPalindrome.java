package suanfa;

import utils.ListNode;

public class _10IsPalindrome {
  // 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表如果是，返回 true ；否则，返回 false 。
  public boolean isPalindrome(ListNode head) {
    // Step 1: Find the middle of the list
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // Step 2: Reverse the second half of the list
    ListNode prev = null;
    while (slow != null) {
      ListNode temp = slow.next;
      slow.next = prev;
      prev = slow;
      slow = temp;
    }

    // Step 3: Compare the first and reversed second halves
    ListNode left = head, right = prev;
    while (right != null) {
      if (left.val != right.val) return false;
      left = left.next;
      right = right.next;
    }

    // Step 4: Optionally restore the original list order
    // 这里不实现恢复步骤，因为题目没有要求

    return true;
  }

}
