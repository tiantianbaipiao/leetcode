package suanfa;

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
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }
}



