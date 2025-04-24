/**
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 */
public class _17ClimbStairs {
  // 假设n个阶梯就是有f(n)种方法爬法,要达到f(n)种爬法最后到达楼顶要么就是爬一阶要么就是爬二阶所以
  // f(n) = f(n-1) + f(n-2)
  public int climbStairs(int n) {
    // 如果是只有一个梯子或者两个梯子就只有一种或者两种爬法
    if(n < 3){
      return n;
    }
    // 当只有一个梯子时
    int a = 1;  // f(n-2)
    // 当只有两个梯子时
    int b = 2; // f(n-1)
    // 初始化一个变量用于保存最后的结果
    int result = 0; // f(n)
    for (int i = 3; i <= n; i++){
      result = a + b; // f(n) = f(n-1) + f(n-2)
      a = b; // 更新 f(n-2)
      b = result; // 更新 f(n-1)
    }
    return result;
  }
}
