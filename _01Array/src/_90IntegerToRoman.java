/**
 * 力扣第12题是“整数转罗马数字”，要求将一个整数转换成对应的罗马数字。
 */
public class _90IntegerToRoman {

    public String intToRoman(int num) {
        // 定义罗马数字及其对应的数值
        int[][] romanValues = {
            {1000, 'M'}, {900, 'C', 'M'}, {500, 'D'}, {400, 'C', 'D'},
            {100, 'C'}, {90, 'X', 'C'}, {50, 'L'}, {40, 'X', 'L'},
            {10, 'X'}, {9, 'I', 'X'}, {5, 'V'}, {4, 'I', 'V'}, {1, 'I'}
        };

        // 构建结果字符串
        StringBuilder result = new StringBuilder();

        // 遍历罗马数字及其对应的数值
        for (int[] pair : romanValues) {
            // 获取当前数值
            int value = pair[0];

            // 如果当前数值大于0，则继续处理
            while (num >= value) {
                // 将当前罗马数字添加到结果字符串中
                if (pair.length == 2) {
                    result.append((char) pair[1]);
                } else {
                    result.append((char) pair[1]);
                    result.append((char) pair[2]);
                }

                // 减去当前数值
                num -= value;
            }
        }

        // 返回结果字符串
        return result.toString();
    }
}
