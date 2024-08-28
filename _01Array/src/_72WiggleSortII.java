import java.util.Arrays;

/**
 * 给你一个整数数组 nums，将它重新排列成
 * nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 */
public class _72WiggleSortII {
    /**
     * 实现摆动排序 II
     * @param nums 给定的整数数组
     */
    public void wiggleSort(int[] nums) {
        // 先对数组进行排序
        Arrays.sort(nums);

        // 计算中位数的位置
        int mid = (nums.length - 1) / 2;

        // 从中间开始，交替放置元素
        int[] temp = new int[nums.length];
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= mid; i++) {
            temp[left] = nums[mid - i];
            left += 2;
        }

        for (int i = 0; i <= mid; i++) {
            temp[right] = nums[mid + i];
            right -= 2;
        }

        // 将 temp 数组复制回原数组
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        _72WiggleSortII solution = new _72WiggleSortII();
        int[] nums = {1, 5, 1, 1, 6, 4};
        solution.wiggleSort(nums);

        // 输出结果
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
