package suanfa;

/**
 * 给定一个长度为 n 的整数数组 nums 。
 *
 * 假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数  F 为：
 *
 * F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
 * 返回 F(0), F(1), ..., F(n-1)中的最大值 。
 *
 * 生成的测试用例让答案符合 32 位 整数。
 */
public class _27MaxRotateFunction {
  public int maxRotateFunction(int[] nums) {
    int n = nums.length;
    int totalSum = 0;
    int f = 0;

    // 计算数组的总和以及初始的旋转函数值
    for (int i = 0; i < n; i++) {
      totalSum += nums[i];
      f += i * nums[i];
    }

    // 初始化最大值为初始的旋转函数值
    int maxF = f;

    // 计算其他旋转函数的值
    for (int i = 1; i < n; i++) {
      // 使用之前的旋转函数值来计算新的旋转函数值
      f += totalSum - n * nums[n - i];
      maxF = Math.max(maxF, f);
    }

    return maxF;
  }
}

