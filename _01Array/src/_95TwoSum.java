/**
 * 给你一个下标从 1 开始的整数数组 numbers ，
 * 该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。
 */
public class _95TwoSum {

    /**
     * 寻找两个数的索引，使它们的和等于目标值。
     * @param numbers 已排序的整数数组
     * @param target 目标和
     * @return 返回两个数的索引（从 1 开始）
     */
    public int[] twoSum(int[] numbers, int target) {
        // 定义两个指针，一个指向数组开始，另一个指向数组结束
        int left = 0;
        int right = numbers.length - 1;

        // 当左指针小于右指针时循环
        while (left < right) {
            // 计算当前两个指针指向的数值之和
            int sum = numbers[left] + numbers[right];

            // 如果和等于目标值，则返回索引（注意索引从 1 开始）
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            // 如果和小于目标值，则移动左指针向右
            else if (sum < target) {
                left++;
            }
            // 如果和大于目标值，则移动右指针向左
            else {
                right--;
            }
        }

        // 如果没有找到合适的解，则抛出异常或返回空数组
        throw new IllegalArgumentException("No two sum solution");
    }

    // 测试方法
    public static void main(String[] args) {
        _95TwoSum solution = new _95TwoSum();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(numbers, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}
