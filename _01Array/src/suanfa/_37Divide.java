package suanfa;

/**
 * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 */
public class _37Divide {
  public int divide(int dividend, int divisor) {
    if (divisor == 0) { // 处理除数为0的情况
      throw new IllegalArgumentException("Divisor cannot be zero.");
    }

    if (dividend == Integer.MIN_VALUE && divisor == -1) { // 处理特殊溢出情况
      return Integer.MAX_VALUE;
    }

    boolean isNegative = (dividend < 0) ^ (divisor < 0); // 判断结果是否为负数
    long dvd = Math.abs((long) dividend); // 被除数取绝对值
    long dvs = Math.abs((long) divisor); // 除数取绝对值

    int quotient = 0; // 初始化商
    while (dvd >= dvs) { // 主循环
      long temp = dvs; // 临时变量
      long multiple = 1; // 当前倍数
      while (dvd >= (temp << 1)) { // 二进制形式的快速除法
        temp <<= 1; // 左移相当于乘以2
        multiple <<= 1; // 当前倍数也乘以2
      }
      dvd -= temp; // 减去当前倍数下的除数
      quotient += multiple; // 累加商
    }

    return isNegative ? -quotient : quotient; // 根据正负号返回结果
  }

  public static void main(String[] args) {
    System.out.println(new _37Divide().divide(10, 3));
  }
}
