/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数。
 */
public class _36MyAtoi {
  public int myAtoi(String str) {
    str = str.trim(); // 去除字符串前后的空白字符
    if (str.isEmpty()) { // 如果字符串为空，直接返回 0
      return 0;
    }

    int index = 0, sign = 1, result = 0;
    if (str.charAt(index) == '+' || str.charAt(index) == '-') { // 判断正负号
      sign = str.charAt(index++) == '+' ? 1 : -1;
    }

    // 遍历字符串中的每个字符
    while (index < str.length()) {
      char c = str.charAt(index++);
      if (!Character.isDigit(c)) { // 如果不是数字字符，跳出循环
        break;
      }

      // 检查是否溢出
      if (result > Integer.MAX_VALUE / 10 ||
          (result == Integer.MAX_VALUE / 10 && c > '7')) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }

      // 计算结果
      result = result * 10 + (c - '0');
    }

    return result * sign; // 返回最终结果
  }

  public static void main(String[] args) {
    System.out.println(new _36MyAtoi().myAtoi("-042"));
  }
}
