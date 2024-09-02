import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class _121CloneGraph {

    /**
     * 克隆无向图
     * @param node 图的起始节点
     * @return 克隆后的图的起始节点
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        HashMap<Node, Node> visited = new HashMap<>();
        return dfsClone(node, visited);
    }

    /**
     * 深度优先搜索克隆图
     * @param node 当前节点
     * @param visited 已经克隆过的节点哈希表
     * @return 克隆后的节点
     */
    private Node dfsClone(Node node, HashMap<Node, Node> visited) {
        // 如果当前节点已经被克隆过，直接返回已克隆的节点
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 克隆当前节点
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        // 遍历当前节点的所有邻居
        for (Node neighbor : node.neighbors) {
            // 递归克隆邻居节点，并添加到克隆节点的邻居列表中
            cloneNode.neighbors.add(dfsClone(neighbor, visited));
        }

        return cloneNode;
    }

    // 测试方法
    public static void main(String[] args) {
        // 构建一个简单的无向图
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        _121CloneGraph solution = new _121CloneGraph();
        Node clonedNode = solution.cloneGraph(node1);

        // 输出克隆后的图的信息
        System.out.println("Original: " + node1.val + " Neighbors: " + node1.neighbors);
        System.out.println("Cloned: " + clonedNode.val + " Neighbors: " + clonedNode.neighbors);
    }
}
