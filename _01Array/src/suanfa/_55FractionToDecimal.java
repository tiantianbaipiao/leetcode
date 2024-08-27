package suanfa;

import java.util.HashMap;

/**
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 如果存在多个答案，只需返回 任意一个 。
 */
public class _55FractionToDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0"; // 如果分子为0，直接返回"0"
        }
        
        StringBuilder result = new StringBuilder();
        
        // 判断结果的正负
        boolean isNegative = (numerator > 0) ^ (denominator > 0);
        if (isNegative) {
            result.append('-');
        }
        
        long num = Math.abs((long) numerator); // 转换为长整型并取绝对值
        long den = Math.abs((long) denominator); // 转换为长整型并取绝对值
        
        // 整数部分
        result.append(num / den);
        num %= den; // 更新分子为余数
        
        if (num != 0) {
            result.append('.'); // 添加小数点
        }
        
        HashMap<Long, Integer> seen = new HashMap<>(); // 用于记录已经出现过的余数及其位置
        
        while (num != 0 && !seen.containsKey(num)) {
            seen.put(num, result.length()); // 记录当前位置
            num *= 10;
            result.append(num / den);
            num %= den; // 更新分子为余数
        }
        
        if (seen.containsKey(num)) {
            int index = seen.get(num);
            result.insert(index, "("); // 插入左括号
            result.append(")"); // 添加右括号
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        // 测试数据
        System.out.println(fractionToDecimal(1, 2)); // 输出 "0.5"
        System.out.println(fractionToDecimal(2, 1)); // 输出 "2"
        System.out.println(fractionToDecimal(2, 3)); // 输出 "0.(6)"
        System.out.println(fractionToDecimal(4, 333)); // 输出 "0.(012)"
    }
}
