package suanfa;

/**
 * 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 */
public class _02ClimbStairs {
    public int climbStairs_01(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        // 一个梯子有1种爬法
        // 两个梯子有2种爬法
        // 三个梯子有3种爬法
        // 四个梯子有5种爬法
        // 五个梯子有8种爬法
        // 对于第i个台阶，方法数等于到达第i-1个台阶的方法数加上到达第i-2个台阶的方法数
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

  public static void main(String[] args) {
    _02ClimbStairs cs = new _02ClimbStairs();
    System.out.println(cs.climbStairs_01(5));
  }
}
