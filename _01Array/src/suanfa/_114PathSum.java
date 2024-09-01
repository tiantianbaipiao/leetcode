package suanfa;

public class _114PathSum {

    /**
     * 判断是否存在路径使得路径上节点值之和等于给定的目标值
     *
     * @param root 树的根节点
     * @param targetSum 目标值
     * @return 是否存在满足条件的路径
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSumRecursive(root, targetSum, 0);
    }

    private boolean hasPathSumRecursive(TreeNode node, int targetSum, int currentSum) {
        // 当前路径上的节点值之和
        currentSum += node.val;

        // 如果是叶子节点且路径和等于目标值
        if (node.left == null && node.right == null) {
            return currentSum == targetSum;
        }

        // 递归检查左右子树
        boolean leftResult = false;
        boolean rightResult = false;

        if (node.left != null) {
            leftResult = hasPathSumRecursive(node.left, targetSum, currentSum);
        }
        if (node.right != null) {
            rightResult = hasPathSumRecursive(node.right, targetSum, currentSum);
        }

        return leftResult || rightResult;
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
        // 构建二叉树
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        // 目标值
        int targetSum = 22;

        // 判断是否存在路径使得路径上节点值之和等于目标值
        _114PathSum solution = new _114PathSum();
        boolean result = solution.hasPathSum(root, targetSum);

        // 输出结果
        System.out.println(result); // 应输出 true
    }
}
