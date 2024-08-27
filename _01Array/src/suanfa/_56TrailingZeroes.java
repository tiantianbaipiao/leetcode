package suanfa;

/**
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 */
public class _56TrailingZeroes {
    public static int trailingZeroes(int n) {
        int count = 0;
        
        // 不断除以5，累加商
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        
        return count;
    }

    public static void main(String[] args) {
        // 测试数据
        System.out.println(trailingZeroes(3)); // 输出 0
        System.out.println(trailingZeroes(5)); // 输出 1
        System.out.println(trailingZeroes(10)); // 输出 2
        System.out.println(trailingZeroes(25)); // 输出 6
    }
}
