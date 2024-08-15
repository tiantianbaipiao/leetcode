import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class _51Permutations {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(result, new ArrayList<>(), nums);
    return result;
  }

  private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
    if (tempList.size() == nums.length) {
      result.add(new ArrayList<>(tempList));
    } else {
      for (int num : nums) {
        if (!tempList.contains(num)) {
          tempList.add(num);
          backtrack(result, tempList, nums);
          tempList.remove(tempList.size() - 1);
        }
      }
    }
  }
}

