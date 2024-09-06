/**
 * 请编写一个函数，来判断你是否可以在给定石头数量为 n
 * 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。
 */
public class _147NimGame {
    public boolean canWinNim(int n, int k, int maxX, int x) {
        // 特殊情况处理
        if (n <= x) {
            return false; // 如果初始石头数量小于等于 x，则当前玩家输
        }

        // 如果 n 已经大于 maxX，则当前玩家输
        if (n > maxX) {
            return false;
        }

        // 动态规划状态转移
        boolean[] dp = new boolean[n + 1];
        dp[0] = false; // 初始状态为 false

        for (int i = 1; i <= n; i++) {
            // 尝试取 1 到 k 个石头
            for (int j = 1; j <= k; j++) {
                int next = i - j;
                // 如果取完之后石头数量小于等于 x 或者大于 maxX，则跳过
                if (next <= x || next > maxX) {
                    continue;
                }
                // 如果取完之后对方不能赢，则当前玩家可以赢
                if (!dp[next]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        _147NimGame solution = new _147NimGame();
        int n = 10;
        int k = 3;
        int maxX = 15;
        int x = 5;

        boolean canWin = solution.canWinNim(n, k, maxX, x);
        System.out.println(canWin); // 输出 true 或 false
    }
}
