import java.util.HashSet;
import java.util.Set;

/**
 * 力扣160 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class _03GetIntersectionNode {
  //Definition for singly-linked list.
  public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
      val = x;
      next = null;
    }
  }

  // 方案一 hashset
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // 1. 创建一个hashset
    Set<ListNode> set = new HashSet<>();
    // 2. 把单链表A存入set集合
    ListNode temp = headA;
    while (temp != null){
      set.add(temp);
      temp = temp.next;
    }
    // 3. 判断链表B中的结点是否出现在集合，若出现这个结点就是相交结点
    // 集合存储的是这个结点的地址而不仅仅是值，只有值和地址相同才能判断是同一个结点
    temp = headB;
    while (temp != null){
      if(set.contains(temp)){
        return temp;
      }
      temp = temp.next;
    }
    return null;
  }

  // 方案二 双链表 追及相遇问题
  public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
    // 1. 判断两个链表是否为空
    if(headA == null || headB == null){
      return null;
    }
    // 2. 用两个指针指向头结点并且同时相后遍历 当A指针遍历完A链表则用A指针继续遍历B链表
    // 当B指针遍历完B链表则用B指针继续遍历A链表
    // 两个指针执行的同一个结点则是相交结点，如果没有则返回null
    ListNode Pa = headA;
    ListNode Pb = headB;
    while (Pa != Pb){
      // 当指针Pa到达A链表末尾时，跳转到B链表的头节点
      if(Pa == null){
        Pa = headB;
      }else {
        Pa = Pa.next;
      }

      // 当指针Pb到达B链表末尾时，跳转到A链表的头节点
      if(Pb == null){
        Pb = headA;
      }else {
        Pb = Pb.next;
      }
    }
    // 返回相交结点
    return Pa;
  }

}
