import java.util.HashMap;
import java.util.Map;

public class _112ConstructBinaryTreeFromInorderAndPostorder {

    /**
     * 从中序与后序遍历序列构造二叉树
     *
     * @param inorder 中序遍历序列
     * @param postorder 后序遍历序列
     * @return 重建的二叉树根节点
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        // 构建索引映射，便于快速查找中序遍历中的节点位置
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeRecursive(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, indexMap);
    }

    private TreeNode buildTreeRecursive(int[] postorder, int postStart, int postEnd,
                                        int[] inorder, int inStart, int inEnd,
                                        Map<Integer, Integer> indexMap) {
        if (postStart > postEnd) {
            return null;
        }

        // 后序遍历的最后一个元素是根节点
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);

        // 在中序遍历中找到根节点的位置
        int rootIndex = indexMap.get(rootValue);

        // 左子树的节点数量
        int leftSize = rootIndex - inStart;

        // 递归构建左子树
        root.left = buildTreeRecursive(postorder, postStart, postStart + leftSize - 1,
                                       inorder, inStart, rootIndex - 1, indexMap);

        // 递归构建右子树
        root.right = buildTreeRecursive(postorder, postStart + leftSize, postEnd - 1,
                                        inorder, rootIndex + 1, inEnd, indexMap);

        return root;
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
        // 构建中序遍历和后序遍历序列
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        // 构建二叉树
        _112ConstructBinaryTreeFromInorderAndPostorder solution = new _112ConstructBinaryTreeFromInorderAndPostorder();
        TreeNode root = solution.buildTree(inorder, postorder);

        // 打印二叉树
        printTree(root);
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.print("null, ");
            return;
        }
        System.out.print(root.val + ", ");
        printTree(root.left);
        printTree(root.right);
    }
}
