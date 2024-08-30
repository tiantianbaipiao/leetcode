/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 */
public class _92ZigzagConversion {

    public String convert(String s, int numRows) {
        if (s == null || numRows <= 1) return s;

        // 初始化二维数组，用于存储每一行的字符
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int n = s.length();
        int row = 0;
        boolean goingDown = false;

        // 遍历字符串中的每个字符
        for (int i = 0; i < n; i++) {
            // 将当前字符添加到对应的行
            rows[row].append(s.charAt(i));

            // 判断当前行是否到达边界
            if (row == 0) {
                goingDown = true;
            } else if (row == numRows - 1) {
                goingDown = false;
            }

            // 根据方向更新行号
            if (goingDown) {
                row++;
            } else {
                row--;
            }
        }

        // 将所有行连接起来
        StringBuilder result = new StringBuilder();
        for (StringBuilder rowStr : rows) {
            result.append(rowStr);
        }

        return result.toString();
    }
}
