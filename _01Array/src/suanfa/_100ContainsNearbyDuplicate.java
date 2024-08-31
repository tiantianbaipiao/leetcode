package suanfa;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 */
public class _100ContainsNearbyDuplicate {

    /**
     * 判断数组中是否存在两个不同的索引 i 和 j，使得 nums[i] == nums[j] 并且 |i - j| <= k。
     * @param nums 整数数组
     * @param k 整数 k
     * @return 如果存在这样的索引对，返回 true；否则返回 false
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // 检查当前数字是否已经在哈希表中
            if (indexMap.containsKey(num)) {
                // 获取当前数字最后一次出现的位置
                int lastIndex = indexMap.get(num);
                // 计算当前位置与最后一次出现位置的距离
                if (i - lastIndex <= k) {
                    return true;
                }
            }

            // 更新当前数字的位置
            indexMap.put(num, i);
        }

        return false;
    }

    // 测试方法
    public static void main(String[] args) {
        _100ContainsNearbyDuplicate solution = new _100ContainsNearbyDuplicate();
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        boolean result1 = solution.containsNearbyDuplicate(nums1, k1);
        System.out.println(result1);  // 输出 true

        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        boolean result2 = solution.containsNearbyDuplicate(nums2, k2);
        System.out.println(result2);  // 输出 true

        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        boolean result3 = solution.containsNearbyDuplicate(nums3, k3);
        System.out.println(result3);  // 输出 false
    }
}
