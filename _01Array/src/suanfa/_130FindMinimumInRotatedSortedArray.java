package suanfa;

public class _130FindMinimumInRotatedSortedArray {

    /**
     * 寻找旋转排序数组中的最小值
     * @param nums 旋转排序数组
     * @return 最小值
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }

        int left = 0;
        int right = nums.length - 1;

        // 如果数组没有旋转，则最小值就是第一个元素
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 如果中间元素大于右侧元素，则最小值在右侧
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // 如果中间元素小于右侧元素，则最小值在左侧
            else if (nums[mid] < nums[right]) {
                right = mid;
            }
            // 如果中间元素等于右侧元素，则无法确定最小值位置，右侧指针向前移动一位
            else {
                right--;
            }
        }

        return nums[left];
    }

    // 测试方法
    public static void main(String[] args) {
        _130FindMinimumInRotatedSortedArray solution = new _130FindMinimumInRotatedSortedArray();

        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(solution.findMin(nums1)); // 应输出 1

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution.findMin(nums2)); // 应输出 0

        int[] nums3 = {2, 2, 2, 0, 1};
        System.out.println(solution.findMin(nums3)); // 应输出 0
    }
}
