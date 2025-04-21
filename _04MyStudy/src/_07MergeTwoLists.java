/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 力扣 21
 *
 */
public class _07MergeTwoLists {
  // Definition for singly-linked list.
   public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // 递归的方法解决
  public ListNode method_1(ListNode list1, ListNode list2){
     // 递归的终止条件是 list1 遍历完 或者list2 遍历完
    if(list1 == null){
      return list2;
    }
    if (list2 == null){
      return list1;
    }
    if(list1.val < list2.val){
      list1.next = method_1(list1.next,list2);
      return list1;
    }else {
      list2.next = method_1(list1,list2.next);
      return list2;
    }
  }
  // 迭代法解决
  public ListNode method_2(ListNode list1, ListNode list2){
     // 1. 定义一个辅助节点
    ListNode prehead = new ListNode(-1);
    // prev指针指向这个辅助节点
    ListNode prev = prehead;
    // 开始循环
    while (list1 != null && list2 != null){
      if(list1.val <= list2.val){
        prev.next = list1;
        list1 = list1.next;
      }else {
        prev.next = list2;
        list2 = list2.next;
      }
      prev = prev.next;
    }
    // 合并后 list1 和 list2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
    prev.next = list1 == null ? list2 : list1;
     return prehead.next;
  }
}
