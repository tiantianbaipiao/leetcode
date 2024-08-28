import java.util.TreeMap;

/**
 * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。
 * 数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 */
public class _71CountOfSmallerNumbersAfterSelf {
    /**
     * 计算右侧小于当前元素的个数
     * @param nums 给定的整数数组
     * @return 结果数组，表示每个元素右侧小于它的元素个数
     */
    public int[] countSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // 使用 TreeMap 来存储元素及其出现次数
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        // 从右往左遍历数组
        for (int i = n - 1; i >= 0; i--) {
            // 计算当前元素右侧小于它的元素个数
            result[i] = treeMap.headMap(nums[i]).size();

            // 将当前元素加入 TreeMap
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        _71CountOfSmallerNumbersAfterSelf solution = new _71CountOfSmallerNumbersAfterSelf();
        int[] nums = {5, 2, 6, 1};
        int[] result = solution.countSmaller(nums);

        // 输出结果
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
