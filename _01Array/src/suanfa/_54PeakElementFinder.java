package suanfa;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 */
public class _54PeakElementFinder {
    public static int findPeakElement(int[] nums) {
        // 如果数组为空或只有一个元素，则直接返回索引0或0
        if (nums == null || nums.length == 1) {
            return 0;
        }
        
        // 设置二分查找的左右边界
        int left = 0, right = nums.length - 1;
        
        // 开始二分查找
        while (left < right) {
            int mid = left + (right - left) / 2; // 计算中间位置
            
            // 如果中间元素比下一个元素大，则峰值在左侧（包括中间位置）
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else { // 否则峰值在右侧
                left = mid + 1;
            }
        }
        
        // 当 left == right 时，找到了峰值
        return left;
    }

    public static void main(String[] args) {
        // 测试数据
        int[] test1 = {1, 2, 3, 1};
        int[] test2 = {1, 2, 1, 3, 5, 6, 4};
        
        // 输出结果
        System.out.println(findPeakElement(test1)); // 可能输出 2
        System.out.println(findPeakElement(test2)); // 可能输出 5 或 1
    }
}
