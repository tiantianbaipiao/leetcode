/**
 * 给定两个整数 a 和 b，计算它们的和，但不能使用加法运算符 + 和减法运算符 -。
 */
public class _79GetSum {
    public int getSum(int a, int b) {
        // 32位掩码
        int mask = 0xFFFFFFFF;

        while (b != 0) {
            // 计算不进位的和
            int sum = (a ^ b) & mask;

            // 计算进位
            int carry = ((a & b) << 1) & mask;

            // 更新 a 和 b
            a = sum;
            b = carry;

            // 检查是否有溢出
            if (b == 0) {
                break;
            }
        }

        // 处理负数的情况
        if ((a & 0x80000000) != 0) {
            return ~(a ^ mask);
        }

        return a;
    }
}
