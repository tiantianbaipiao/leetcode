package suanfa;

/**
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
 */
public class _53ExcelColumnNumber {
    public static int titleToNumber(String columnTitle) {
        // 初始化结果变量为0
        int result = 0;
        
        // 遍历字符串中的每一个字符
        for (char c : columnTitle.toCharArray()) {
            // 将当前字符减去'A'的 ASCII 值，再加上1得到其在序列中的位置
            // 然后乘以 26 的幂次方（基于当前字符在字符串中的位置倒序计算）
            result = result * 26 + (c - 'A' + 1);
        }
        
        // 返回计算后的结果
        return result;
    }

    public static void main(String[] args) {
        // 测试数据
        String test1 = "A";
        String test2 = "AB";
        String test3 = "ZY";
        
        // 输出结果
        System.out.println(titleToNumber(test1)); // 应输出 1
        System.out.println(titleToNumber(test2)); // 应输出 28
        System.out.println(titleToNumber(test3)); // 应输出 701
    }
}
