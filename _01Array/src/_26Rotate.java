public class _26Rotate {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; // 处理 k 大于数组长度的情况

        reverse(nums, 0, n - 1); // 反转整个数组
        reverse(nums, 0, k - 1); // 反转前 k 个元素
        reverse(nums, k, n - 1); // 反转剩余的元素
    }

    // 辅助方法，反转数组中的一部分
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // 交换 start 和 end 位置的元素
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            // 更新 start 和 end 的位置
            start++;
            end--;
        }
    }
}
