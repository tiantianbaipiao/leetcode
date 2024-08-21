import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _13SetMismatch {
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;

        // 统计每个数字出现的次数
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 查找重复和缺失的数字
        int duplicate = -1;
        int missing = -1;
        for (int i = 1; i <= n; i++) {
            if (countMap.getOrDefault(i, 0) == 2) {
                duplicate = i;
            } else if (!countMap.containsKey(i)) {
                missing = i;
            }

            // 一旦找到重复和缺失的数字，即可退出循环
            if (duplicate != -1 && missing != -1) {
                break;
            }
        }

        return new int[]{duplicate, missing};
    }

    // 测试函数
    public static void main(String[] args) {
        _13SetMismatch solution = new _13SetMismatch();
        int[] testArray = {1, 2, 2, 4};
        int[] result = solution.findErrorNums(testArray);
        System.out.println(Arrays.toString(result)); // 应输出 [2, 3]
    }
}
