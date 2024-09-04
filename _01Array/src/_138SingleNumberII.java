public class _138SingleNumberII {

    /**
     * 查找数组中只出现一次的数字。
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现三次。
     * 找出那个只出现一次的数字。
     *
     * @param nums 输入的整数数组
     * @return 只出现一次的数字
     */
    public int singleNumber(int[] nums) {
        // 初始化三个状态变量
        int ones = 0; // 存储出现一次的状态
        int twos = 0; // 存储出现两次的状态
        int threes = 0; // 存储出现三次的状态

        for (int num : nums) {
            // 更新状态
            twos |= ones & num; // 出现两次的状态更新
            ones ^= num; // 出现一次的状态更新

            // 清除出现三次的状态
            threes = ones & twos; // 出现三次的状态
            ones &= ~threes; // 清除出现三次的状态
            twos &= ~threes; // 清除出现三次的状态
        }

        return ones; // 最后剩下的状态就是只出现一次的数字
    }

    public static void main(String[] args) {
        _138SingleNumberII solution = new _138SingleNumberII();

        // 测试用例
        int[] nums1 = {2, 2, 3, 2};
        System.out.println(solution.singleNumber(nums1)); // 输出应为3

        int[] nums2 = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(solution.singleNumber(nums2)); // 输出应为99
    }
}
