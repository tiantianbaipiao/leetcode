package suanfa;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 */
public class _30RomanToInt {
  public static int romanToInt(String s) {
    // 定义一个映射表，将罗马数字字符映射到它们的值
    Map<Character, Integer> romanValues = new HashMap<>();
    romanValues.put('I', 1);
    romanValues.put('V', 5);
    romanValues.put('X', 10);
    romanValues.put('L', 50);
    romanValues.put('C', 100);
    romanValues.put('D', 500);
    romanValues.put('M', 1000);

    // 初始化结果为 0
    int result = 0;
    // 遍历输入字符串中的每个字符
    for (int i = 0; i < s.length(); i++) {
      // 如果当前字符代表的数值小于下一个字符代表的数值，则从结果中减去这个值
      if (i + 1 < s.length() && romanValues.get(s.charAt(i)) < romanValues.get(s.charAt(i + 1))) {
        result -= romanValues.get(s.charAt(i));
      } else {
        // 否则，加上这个值
        result += romanValues.get(s.charAt(i));
      }
    }
    // 返回最终结果
    return result;
  }

  // 测试方法
  public static void main(String[] args) {
    System.out.println(romanToInt("III"));      // 输出: 3
    System.out.println(romanToInt("IV"));       // 输出: 4
    System.out.println(romanToInt("IX"));       // 输出: 9
    System.out.println(romanToInt("LVIII"));    // 输出: 58
    System.out.println(romanToInt("MCMXCIV"));  // 输出: 1994
  }
}

