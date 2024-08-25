package suanfa;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 */
public class _33SqrtX {
    public static int mySqrt(int x) {
        // 边界情况处理
        if (x == 0 || x == 1) {
            return x;
        }

        // 初始化左右边界
        int left = 1, right = x;

        // 二分查找
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 计算 mid 的平方
            long square = (long) mid * mid;

            // 如果平方正好等于 x，则返回 mid
            if (square == x) {
                return mid;
            }

            // 如果平方大于 x，则将右边界调整为 mid - 1
            if (square > x) {
                right = mid - 1;
            } else {
                // 如果平方小于 x，则将左边界调整为 mid + 1
                left = mid + 1;
            }
        }

        // 当循环结束时，right 就是最接近 x 的平方根的整数
        return right;
    }

    // 测试方法
    public static void main(String[] args) {
        System.out.println(mySqrt(4));   // 输出: 2
        System.out.println(mySqrt(8));   // 输出: 2
        System.out.println(mySqrt(1));   // 输出: 1
        System.out.println(mySqrt(16));  // 输出: 4
    }
}
