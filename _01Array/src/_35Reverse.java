/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 */
public class _35Reverse {
  public int reverse(int x) {
    long reversed = 0; // 使用 long 类型防止溢出

    while (x != 0) {
      reversed = reversed * 10 + x % 10; // 逐位反转数字
      x /= 10;

      // 检查是否溢出
      if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
        return 0;
      }
    }

    return (int) reversed;
  }

  public static void main(String[] args) {
    System.out.println(new _35Reverse().reverse(123));
  }
}
