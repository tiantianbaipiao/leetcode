package suanfa;

import utils.ListNode;

import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class _101MergeKLists {

  // 合并 K 个排序链表
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
    for (ListNode list : lists) {
      if (list != null) {
        heap.add(list);
      }
    }

    ListNode dummy = new ListNode(0);  // 哑节点
    ListNode current = dummy;

    while (!heap.isEmpty()) {
      ListNode node = heap.poll();
      current.next = node;
      current = current.next;

      if (node.next != null) {
        heap.add(node.next);
      }
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    _101MergeKLists solution = new _101MergeKLists();

    // 创建链表
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(5);

    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);

    ListNode l3 = new ListNode(2);
    l3.next = new ListNode(6);

    ListNode[] lists = {l1, l2, l3};

    ListNode mergedList = solution.mergeKLists(lists);

    // 打印合并后的链表
    while (mergedList != null) {
      System.out.print(mergedList.val + " -> ");
      mergedList = mergedList.next;
    }
    System.out.println("null");
  }
}

