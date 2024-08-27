import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，
 * 返回 true ；如果数组中每个元素互不相同，返回 false 。
 */
public class _62ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        
        // 遍历数组
        for (int num : nums) {
            // 如果已经在 set 中，则存在重复
            if (seen.contains(num)) {
                return true;
            }
            // 否则，将当前元素添加到 set 中
            seen.add(num);
        }
        
        // 没有发现重复元素
        return false;
    }

    public static void main(String[] args) {
        // 测试数据
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        
        // 输出结果
        System.out.println(containsDuplicate(nums1)); // 输出 true
        System.out.println(containsDuplicate(nums2)); // 输出 false
    }
}
