public class _137BitwiseANDRange {

    /**
     * 计算[m, n]范围内所有整数的按位与结果。
     * 
     * @param m 范围的起始值
     * @param n 范围的结束值
     * @return 按位与结果
     */
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        
        // 找到m和n相同的最高位
        while (m < n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        
        // 将相同的最高位恢复回来
        return m << shift;
    }

    public static void main(String[] args) {
        _137BitwiseANDRange solution = new _137BitwiseANDRange();
        
        // 测试用例
        int m = 5;
        int n = 7;
        System.out.println(solution.rangeBitwiseAnd(m, n)); // 输出应为4
        
        m = 0;
        n = 0;
        System.out.println(solution.rangeBitwiseAnd(m, n)); // 输出应为0
        
        m = 1;
        n = 2147483647;
        System.out.println(solution.rangeBitwiseAnd(m, n)); // 输出应为0
    }
}
