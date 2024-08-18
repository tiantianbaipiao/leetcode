import utils.TreeNode;
/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 */
public class _86PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return dfs(root, targetSum) +
               pathSum(root.left, targetSum) +
               pathSum(root.right, targetSum);
    }

    private int dfs(TreeNode node, int targetSum) {
        if (node == null) return 0;
        int count = 0;
        if (node.val == targetSum) count++;  // 当前节点等于目标值

        // 递归左右子树
        count += dfs(node.left, targetSum - node.val);
        count += dfs(node.right, targetSum - node.val);

        return count;
    }

    public static void main(String[] args) {
        // 构建二叉树
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);

        _86PathSumIII solution = new _86PathSumIII();
        int targetSum = 8;
        int result = solution.pathSum(root, targetSum);
        System.out.println(result);  // 输出: 3
    }
}
