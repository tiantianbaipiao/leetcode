package suanfa;

/**
 * 有一个单链表的 head，我们想删除它其中的一个节点 node。
 *
 * 给你一个需要删除的节点 node 。你将 无法访问 第一个节点  head。
 *
 * 链表的所有值都是 唯一的，并且保证给定的节点 node 不是链表中的最后一个节点。
 */
public class _66DeleteNode {
  /**
   * 删除链表中的节点
   * @param node 要删除的节点
   */
  public static void deleteNode(ListNode node) {
    // 将要删除节点的下一个节点的值复制到当前节点
    node.val = node.next.val;

    // 将当前节点的 next 指针指向下一个节点的 next 指针
    node.next = node.next.next;
  }

  // 定义 ListNode 类
  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public static void main(String[] args) {
    // 创建一个示例链表
    ListNode head = new ListNode(4);
    head.next = new ListNode(5);
    head.next.next = new ListNode(1);
    head.next.next.next = new ListNode(9);

    // 打印原始链表
    printList(head);

    // 删除节点
    deleteNode(head.next); // 删除值为 5 的节点

    // 打印修改后的链表
    printList(head);
  }

  // 打印链表的方法
  private static void printList(ListNode head) {
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val + " -> ");
      current = current.next;
    }
    System.out.println("null");
  }
}

