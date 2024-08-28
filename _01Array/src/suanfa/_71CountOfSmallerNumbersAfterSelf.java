package suanfa;

import java.util.*;

/**
 * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。
 * 数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 */
public class _71CountOfSmallerNumbersAfterSelf {
    /**
     * 计算右侧小于当前元素的个数
     * @param nums 给定的整数列表
     * @return 结果列表，表示每个元素右侧小于它的元素个数
     */
    public List<Integer> countSmaller(List<Integer> nums) {
        int n = nums.size();
        List<Integer> result = new ArrayList<>(n);

        // 使用 TreeMap 来存储元素及其出现次数
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        // 从右往左遍历列表
        for (int i = n - 1; i >= 0; i--) {
            // 计算当前元素右侧小于它的元素个数
            int count = treeMap.headMap(nums.get(i)).size();

            // 将当前元素加入 TreeMap
            treeMap.put(nums.get(i), treeMap.getOrDefault(nums.get(i), 0) + 1);

            // 将结果添加到列表中
            result.add(count);
        }

        // 反转结果列表，因为是从右往左遍历的
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        _71CountOfSmallerNumbersAfterSelf solution = new _71CountOfSmallerNumbersAfterSelf();
        List<Integer> nums = Arrays.asList(5, 2, 6, 1);
        List<Integer> result = solution.countSmaller(nums);

        // 输出结果
        System.out.println(result); // 输出 [2, 1, 1, 0]
    }
}

