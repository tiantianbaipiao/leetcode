import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class _50CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates); // 先排序以便剪枝
    backtrack(result, new ArrayList<>(), candidates, target, 0);
    return result;
  }

  private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
    if (remain < 0) return; // 超过目标值
    else if (remain == 0) result.add(new ArrayList<>(tempList)); // 找到一个组合
    else {
      for (int i = start; i < candidates.length; i++) {
        tempList.add(candidates[i]);
        backtrack(result, tempList, candidates, remain - candidates[i], i); // 不是i + 1，因为可以重复使用
        tempList.remove(tempList.size() - 1); // 回溯
      }
    }
  }
}

