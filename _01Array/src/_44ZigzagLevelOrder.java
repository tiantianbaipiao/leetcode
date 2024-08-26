import utils.TreeNode;
import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class _44ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        // 如果根节点为空，则直接返回空列表
        if (root == null) {
            return result;
        }

        // 创建一个队列用于存储当前层的节点
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点加入队列
        queue.offer(root);
        
        // 标志位，用于控制当前层的输出顺序
        boolean reverse = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            // 遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();

                // 根据标志位决定是否反转当前层的输出顺序
                if (reverse) {
                    currentLevel.add(0, currentNode.val); // 反转时在列表头部插入元素
                } else {
                    currentLevel.add(currentNode.val); // 正常顺序时在列表尾部添加元素
                }

                // 将当前节点的左右子节点加入队列
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // 添加当前层的结果到最终结果列表
            result.add(currentLevel);
            
            // 切换标志位
            reverse = !reverse;
        }

        return result;
    }
}
