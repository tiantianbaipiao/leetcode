import utils.TreeNode;

/**
 * 要求计算打家劫舍 III 的问题。在这个问题中，一棵二叉树代表了一栋房子的结构，
 * 每个节点表示一个房间，节点的值表示该房间内存放的现金数额。相邻的两个房间安装了
 * 相互连通的防盗系统，如果两个相邻房间在同一晚上被打劫，则自动报警。
 * 给定这棵二叉树的根节点 root，计算在不触动警报的情况下，能够打劫的最高现金数额。
 */
public class _81Rob {
  public int rob(TreeNode root) {
    int[] result = robHelper(root);
    // 返回两个选项中的较大值
    return Math.max(result[0], result[1]);
  }

  // 辅助方法，返回不抢劫和抢劫当前节点的最大收益
  private int[] robHelper(TreeNode node) {
    if (node == null) {
      return new int[]{0, 0};
    }

    // 递归处理左右子树
    int[] left = robHelper(node.left);
    int[] right = robHelper(node.right);

    // 不抢劫当前节点时的最大收益
    int noRobbery = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

    // 抢劫当前节点时的最大收益
    int robbery = node.val + left[0] + right[0];

    return new int[]{noRobbery, robbery};
  }
}
