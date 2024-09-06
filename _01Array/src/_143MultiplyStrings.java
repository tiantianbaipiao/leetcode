/**
 * 给定两个以字符串形式表示的非负整数
 * num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式
 */
public class _143MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length(), n = num2.length();
        int[] result = new int[m + n];

        // 从低位到高位计算每一位的乘积
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + result[p2];

                // 计算进位
                result[p1] += sum / 10;
                result[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            if (!(sb.length() == 0 && digit == 0)) { // 跳过前导零
                sb.append(digit);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        _143MultiplyStrings solution = new _143MultiplyStrings();
        String num1 = "123";
        String num2 = "456";
        System.out.println(solution.multiply(num1, num2)); // 输出 "56088"
    }
}
