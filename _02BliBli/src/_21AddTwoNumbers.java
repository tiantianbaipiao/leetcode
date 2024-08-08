import utils.ListNode;

public class _21AddTwoNumbers {
  // 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
  //
  //请你将两个数相加，并以相同形式返回一个表示和的链表。
  //
  //你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // 创建一个哑节点作为结果链表的头部
    ListNode dummyHead = new ListNode(0);
    ListNode currentNode = dummyHead;
    int carryOver = 0; // 初始化进位值

    // 当两个链表都不为空或仍有进位时循环
    while (l1 != null || l2 != null || carryOver != 0) {
      // 计算当前位的和
      int val1 = (l1 != null) ? l1.val : 0;
      int val2 = (l2 != null) ? l2.val : 0;
      int sum = val1 + val2 + carryOver;

      // 更新进位
      carryOver = sum / 10;

      // 创建新节点存储当前位的结果
      currentNode.next = new ListNode(sum % 10);
      currentNode = currentNode.next;

      // 移动到下一个节点
      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;
    }

    // 返回结果链表的头节点
    return dummyHead.next;
  }

}
