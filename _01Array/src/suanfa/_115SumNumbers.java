package suanfa;

public class _115SumNumbers {

    /**
     * 计算从根节点到叶子节点的所有路径数字之和
     *
     * @param root 树的根节点
     * @return 路径数字之和
     */
    public int sumNumbers(TreeNode root) {
        return sumNumbersRecursive(root, 0);
    }

    private int sumNumbersRecursive(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        // 当前路径上的节点值之和
        currentSum = currentSum * 10 + node.val;

        // 如果是叶子节点，返回当前路径数字之和
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // 递归检查左右子树
        int leftSum = sumNumbersRecursive(node.left, currentSum);
        int rightSum = sumNumbersRecursive(node.right, currentSum);

        return leftSum + rightSum;
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
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        // 计算从根节点到叶子节点的所有路径数字之和
        _115SumNumbers solution = new _115SumNumbers();
        int result = solution.sumNumbers(root);

        // 输出结果
        System.out.println(result); // 应输出 1026
    }
}
