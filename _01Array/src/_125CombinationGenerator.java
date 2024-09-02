import java.util.ArrayList;
import java.util.List;

public class _125CombinationGenerator {

    /**
     * 生成所有可能的 k 个数的组合
     * @param n 总数
     * @param k 选择的数量
     * @return 所有可能的组合列表
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    /**
     * 回溯算法生成组合
     * @param result 结果列表
     * @param current 当前组合
     * @param start 下一个数字的起始位置
     * @param n 总数
     * @param k 选择的数量
     */
    private void backtrack(List<List<Integer>> result, List<Integer> current, int start, int n, int k) {
        // 如果当前组合长度等于 k，则添加到结果列表中
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // 递归选择下一个数字
        for (int i = start; i <= n; i++) {
            current.add(i); // 选择当前数字
            backtrack(result, current, i + 1, n, k); // 递归选择下一个数字
            current.remove(current.size() - 1); // 回溯，取消选择当前数字
        }
    }

    // 测试方法
    public static void main(String[] args) {
        _125CombinationGenerator generator = new _125CombinationGenerator();
        List<List<Integer>> combinations = generator.combine(4, 2);
        System.out.println(combinations); // 应输出 [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
    }
}
