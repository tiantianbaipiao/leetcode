import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定两个数组 nums1 和 nums2，返回它们的交集。每个元素在结果中出现的次数应与元素
 * 在两个数组中都出现的次数相同（如果出现次数不相同，则取较小值）。可以假设数组中每个元素都是唯一的。
 */
public class _78Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // 统计 nums1 中每个元素的出现次数
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 遍历 nums2，统计交集
        for (int num : nums2) {
            if (countMap.containsKey(num) && countMap.get(num) > 0) {
                result.add(num);
                countMap.put(num, countMap.get(num) - 1);
            }
        }

        // 将结果转换为数组
        int[] output = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }

        return output;
    }
}
