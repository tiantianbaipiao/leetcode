import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 给定一个非空二叉树的根节点 root ,
 * 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 */
public class _119LayerAverages {

    /**
     * 计算二叉树每一层的平均值
     * @param root 树的根节点
     * @return 每一层的平均值列表
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            // 如果根节点为空，则直接返回空列表
            return result;
        }

        // 使用队列进行广度优先搜索
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0; // 当前层节点值之和
            int count = 0;  // 当前层节点数量

            // 每次循环处理当前队列中的所有节点（同一层）
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val; // 累加节点值
                count++;         // 增加节点计数

                // 将左右子节点加入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // 计算当前层的平均值并添加到结果列表
            double average = sum / count;
            result.add(average);
        }

        return result;
    }

    // 测试方法
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        _119LayerAverages solution = new _119LayerAverages();
        List<Double> result = solution.averageOfLevels(root);
        System.out.println(result); // 应输出 [3.0, 14.5, 11.0]
    }
}
