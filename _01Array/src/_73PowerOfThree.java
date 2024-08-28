/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 */
public class _73PowerOfThree {

    /**
     * 判断一个整数是否可以表示为 3 的某个整数次幂
     * @param n 给定的整数
     * @return 如果 n 可以表示为 3 的某个整数次幂，则返回 true；否则返回 false
     */
    public boolean isPowerOfThree(int n) {
        // 特殊情况处理：n 为负数或 0 时，直接返回 false
        if (n <= 0) {
            return false;
        }

        // 通过不断除以 3 来检查 n 是否可以表示为 3 的某个整数次幂
        while (n % 3 == 0) {
            n /= 3;
        }

        // 最终 n 应该等于 1 才能表示为 3 的某个整数次幂
        return n == 1;
    }

    public static void main(String[] args) {
        _73PowerOfThree solution = new _73PowerOfThree();

        // 测试数据
        int[] testNumbers = {27, 0, -3, 1, 81, 243, 244};

        // 输出结果
        for (int num : testNumbers) {
            System.out.println("Is " + num + " a power of three? " + solution.isPowerOfThree(num));
        }
    }
}
