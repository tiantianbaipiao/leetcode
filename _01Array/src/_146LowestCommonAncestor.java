import utils.TreeNode;

import java.util.Objects;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 */
public class _146LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 空树的情况
        if (root == null) {
            return null;
        }

        // 如果 p 或 q 与 root 相等，则返回 root
        if (Objects.equals(root, p) || Objects.equals(root, q)) {
            return root;
        }

        // 如果 p 和 q 都在 root 的左侧子树中
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // 如果 p 和 q 都在 root 的右侧子树中
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // 如果 p 和 q 分别位于 root 的两侧，则 root 就是 LCA
        return root;
    }

    public static void main(String[] args) {
        // 构建二叉搜索树
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left.right.left; // 3
        TreeNode q = root.left.right.right; // 5

        _146LowestCommonAncestor solution = new _146LowestCommonAncestor();
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println(lca.val); // 输出 4
    }
}
