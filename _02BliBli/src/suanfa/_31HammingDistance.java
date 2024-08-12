package suanfa;

/**
 *  两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 *  给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 */
public class _31HammingDistance {
    public int hammingDistance(int x, int y) {
        int res = 0;
        int xor = x ^ y;
        while (xor != 0) {
            res += xor & 1;
            xor >>= 1;
        }
        return res;
    }
}
