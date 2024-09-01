package suanfa;

public class _111SameTree {

    /**
     * 判断两棵二叉树是否相同
     *
     * @param p 第一棵二叉树的根节点
     * @param q 第二棵二叉树的根节点
     * @return 如果两棵树相同返回 true，否则返回 false
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果两棵树都为空，则认为它们相同
        if (p == null && q == null) {
            return true;
        }
        // 如果一棵树为空而另一棵不为空，则认为它们不同
        if (p == null || q == null) {
            return false;
        }
        // 如果两棵树的根节点值不同，则认为它们不同
        if (p.val != q.val) {
            return false;
        }
        // 递归地比较两棵树的左子树和右子树
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
        // 构建第一棵二叉树 1->2->3
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // 构建第二棵二叉树 1->2->3
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        // 判断两棵树是否相同
        _111SameTree solution = new _111SameTree();
        boolean result = solution.isSameTree(p, q);
        System.out.println(result); // 输出 true

        // 构建第三棵二叉树 1->2
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);

        // 构建第四棵二叉树 1->null->2
        TreeNode s = new TreeNode(1);
        s.right = new TreeNode(2);

        // 判断两棵树是否相同
        result = solution.isSameTree(r, s);
        System.out.println(result); // 输出 false
    }
}
