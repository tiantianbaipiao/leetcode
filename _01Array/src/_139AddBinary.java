public class _139AddBinary {

    /**
     * 计算两个二进制字符串的按位异或结果。
     * 
     * @param a 第一个二进制字符串
     * @param b 第二个二进制字符串
     * @return 异或结果的二进制字符串
     */
    public String addBinary(String a, String b) {
        // 初始化结果字符串和进位标志
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        // 从最低位开始逐位计算
        while (i >= 0 || j >= 0 || carry == 1) {
            // 获取当前位的值
            int bitA = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j--) - '0' : 0;

            // 计算当前位的异或结果
            int xorResult = bitA ^ bitB ^ carry;
            result.append(xorResult);

            // 更新进位标志
            carry = (bitA & bitB) | (bitA & carry) | (bitB & carry);
        }

        // 反转结果字符串
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        _139AddBinary solution = new _139AddBinary();

        // 测试用例
        String a1 = "11";
        String b1 = "1";
        System.out.println(solution.addBinary(a1, b1)); // 输出应为 "100"

        String a2 = "1010";
        String b2 = "1011";
        System.out.println(solution.addBinary(a2, b2)); // 输出应为 "10101"
    }
}
