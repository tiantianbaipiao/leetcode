/**
 * 力扣138，随机链表的复制
 */
public class _51CopyRandomList {

  class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }

    // 第一步：复制节点并插入到原节点后面
    Node current = head;
    while (current != null) {
      Node newNode = new Node(current.val);
      newNode.next = current.next;
      current.next = newNode;
      current = newNode.next;
    }

    // 第二步：设置新节点的 random 指针
    current = head;
    while (current != null) {
      if (current.random != null) {
        current.next.random = current.random.next;
      }
      current = current.next.next;
    }

    // 第三步：拆分链表
    Node newHead = head.next;
    current = head;
    while (current != null) {
      Node temp = current.next;
      if (temp != null) {
        current.next = temp.next;
      }
      current = temp;
    }

    return newHead;
  }
}

