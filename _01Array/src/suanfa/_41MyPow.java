package suanfa;

/**
 * 编写一个函数来计算 x 的 n 次幂。其中 x 是浮点数，n 是整数。
 * 我们需要考虑 n 为负数的情况，并且不使用库函数 pow()。
 */
public class _41MyPow {
  public double myPow(double x, int n) {
    long N = n; // 使用 long 类型来处理大整数
    if (N < 0) { // 如果指数为负数
      x = 1 / x; // 取倒数
      N = -N; // 取绝对值
    }

    double result = 1.0; // 初始化结果
    while (N > 0) {
      if (N % 2 == 1) { // 如果 N 为奇数
        result *= x; // 直接乘以 x
      }
      x *= x; // x 自乘
      N /= 2; // N 减半
    }

    return result; // 返回最终结果
  }

  public static void main(String[] args) {
    System.out.println(new _41MyPow().myPow(2.00000, -2));
  }
}
