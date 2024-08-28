/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */
public class _68MissingNumber {
    /**
     * 寻找缺失的数字
     * @param nums 给定的整数数组
     * @return 缺失的数字
     */
    public int missingNumber(int[] nums) {
        // 数组长度
        int n = nums.length;

        // 高斯求和公式计算 [0, n] 的总和
        int totalSum = n * (n + 1) / 2;

        // 计算数组中所有数字的总和
        int arraySum = 0;
        for (int num : nums) {
            arraySum += num;
        }

        // 总和减去数组中所有数字的总和即为缺失的数字
        return totalSum - arraySum;
    }

    public static void main(String[] args) {
        _68MissingNumber solution = new _68MissingNumber();
        int[] nums = {3, 0, 1};
        int missingNumber = solution.missingNumber(nums);
        System.out.println("缺失的数字是: " + missingNumber); // 输出结果应为 2
    }
}
