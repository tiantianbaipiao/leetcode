/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 */
public class _145IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        // 特殊情况处理：n 小于 1 时不可能是 2 的幂次方
        if (n < 1) {
            return false;
        }

        // 判断 n 是否为 2 的幂次方
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        _145IsPowerOfTwo solution = new _145IsPowerOfTwo();
        int n = 16;
        System.out.println(solution.isPowerOfTwo(n)); // 输出 true
    }
}
