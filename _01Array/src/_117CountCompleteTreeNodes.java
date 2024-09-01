/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 */
public class _117CountCompleteTreeNodes {

    /**
     * 计算完全二叉树的节点个数
     *
     * @param root 树的根节点
     * @return 节点总数
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // 二叉树节点定义
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        // 构建完全二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        // 计算节点总数
        _117CountCompleteTreeNodes solution = new _117CountCompleteTreeNodes();
        int result = solution.countNodes(root);

        // 输出结果
        System.out.println(result); // 应输出 6
    }
}
