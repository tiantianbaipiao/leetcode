package suanfa;

/**
 * 编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中
 * 设置位
 *  的个数（也被称为汉明重量）。
 */
public class _59HammingWeight {
    public static int hammingWeight(int n) {
        int count = 0;
        
        // 遍历32位
        for (int i = 0; i < 32; i++) {
            // 计算最低位是否为1
            if ((n & 1) == 1) {
                count++;
            }
            
            // 将n右移一位
            n >>>= 1;
        }
        
        return count;
    }

    public static void main(String[] args) {
        // 测试数据
        int input = 0b00000000000000000000000000001011;
        
        // 输出结果
        System.out.println(hammingWeight(input)); // 输出 3
    }
}
