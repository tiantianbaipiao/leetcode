import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，
 * nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 */
public class _101SummaryRanges {

    /**
     * 返回每个连续的正整数的区间列表。
     * @param nums 无重复元素的有序整数数组
     * @return 区间列表
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();

        if (nums.length == 0) {
            return ranges;
        }

        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 检查当前数字是否与前一个数字连续
            if (nums[i] == end + 1) {
                end = nums[i];
            } else {
                // 添加区间
                addRange(ranges, start, end);
                start = nums[i];
                end = nums[i];
            }
        }

        // 添加最后一个区间
        addRange(ranges, start, end);

        return ranges;
    }

    /**
     * 将区间添加到结果列表中。
     * @param ranges 结果列表
     * @param start 区间起始值
     * @param end 区间结束值
     */
    private void addRange(List<String> ranges, int start, int end) {
        if (start == end) {
            ranges.add(String.valueOf(start));
        } else {
            ranges.add(start + "->" + end);
        }
    }

    // 测试方法
    public static void main(String[] args) {
        _101SummaryRanges solution = new _101SummaryRanges();
        int[] nums1 = {0, 1, 2, 4, 5, 7};
        List<String> result1 = solution.summaryRanges(nums1);
        System.out.println(result1);  // 输出 ["0->2", "4->5", "7"]

        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        List<String> result2 = solution.summaryRanges(nums2);
        System.out.println(result2);  // 输出 ["0", "2->4", "6", "8->9"]

        int[] nums3 = {};
        List<String> result3 = solution.summaryRanges(nums3);
        System.out.println(result3);  // 输出 []
    }
}
