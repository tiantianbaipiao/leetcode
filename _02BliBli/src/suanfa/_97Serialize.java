package suanfa;

import utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，
 * 进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，
 * 采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 */
public class _97Serialize {

  // 序列化二叉树
  public String serialize(TreeNode root) {
    if (root == null) return "#";  // 表示空节点

    StringBuilder sb = new StringBuilder();
    serializeHelper(root, sb);

    return sb.toString();
  }

  // 帮助函数用于序列化
  private void serializeHelper(TreeNode node, StringBuilder sb) {
    if (node == null) {
      sb.append("#,");
      return;
    }

    sb.append(node.val).append(",");
    serializeHelper(node.left, sb);
    serializeHelper(node.right, sb);
  }

  // 反序列化二叉树
  public TreeNode deserialize(String data) {
    Queue<String> queue = new LinkedList<>();
    queue.addAll(Arrays.asList(data.split(",")));  // 将字符串分割为队列

    return deserializeHelper(queue);
  }

  // 帮助函数用于反序列化
  private TreeNode deserializeHelper(Queue<String> queue) {
    String val = queue.poll();
    if ("#".equals(val)) {  // 如果是空节点
      return null;
    }

    TreeNode node = new TreeNode(Integer.parseInt(val));  // 创建新节点
    node.left = deserializeHelper(queue);  // 构建左子树
    node.right = deserializeHelper(queue);  // 构建右子树

    return node;
  }

  public static void main(String[] args) {
    _97Serialize codec = new _97Serialize();

    // 构建示例二叉树
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);

    // 序列化
    String serialized = codec.serialize(root);
    System.out.println("Serialized: " + serialized);

    // 反序列化
    TreeNode deserialized = codec.deserialize(serialized);
    System.out.println("Deserialized: " + codec.serialize(deserialized));
  }
}

