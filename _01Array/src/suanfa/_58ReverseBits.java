package suanfa;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 */
public class _58ReverseBits {
    public static int reverseBits(int n) {
        int result = 0;
        
        // 遍历32位
        for (int i = 0; i < 32; i++) {
            // 获取最低位的比特，并将其移动到最高位
            result <<= 1;
            result |= (n & 1);
            
            // 将n右移一位
            n >>>= 1;
        }
        
        return result;
    }

    public static void main(String[] args) {
        // 测试数据
        int input = 0b00000010100101000001111010011100;
        
        // 输出结果
        System.out.println(reverseBits(input)); // 输出 964176192
    }
}
