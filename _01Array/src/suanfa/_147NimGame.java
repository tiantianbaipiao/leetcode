package suanfa;

/**
 * 请编写一个函数，来判断你是否可以在给定石头数量为 n
 * 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。
 */
public class _147NimGame {
    public boolean canWinNim(int n) {
        // 特殊情况处理
        if (n <= 0) {
            return false; // 如果 n 小于等于 0，则当前玩家输
        }

        // 使用异或操作判断胜负
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        _147NimGame solution = new _147NimGame();
        int n = 4;

        boolean canWin = solution.canWinNim(n);
        System.out.println(canWin); // 输出 false
    }
}

