import utils.TreeNode;
/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 *
 */
public class _120MinAbsoluteDiff {

    private int minDiff = Integer.MAX_VALUE;
    private TreeNode prevNode = null;

    /**
     * 计算二叉搜索树中的最小绝对差
     * @param root 树的根节点
     * @return 最小绝对差
     */
    public int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        return minDiff;
    }

    /**
     * 中序遍历二叉搜索树
     * @param node 当前节点
     */
    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        // 左子树
        inorderTraversal(node.left);

        // 处理当前节点
        if (prevNode != null) {
            // 更新最小差值
            minDiff = Math.min(minDiff, node.val - prevNode.val);
        }
        prevNode = node;

        // 右子树
        inorderTraversal(node.right);
    }

    // 测试方法
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        _120MinAbsoluteDiff solution = new _120MinAbsoluteDiff();
        int result = solution.getMinimumDifference(root);
        System.out.println(result); // 应输出 1
    }
}
