import java.util.ArrayList;
import java.util.List;

public class _05FindDisappearedNumbers {

  /**
   * 找出所有在 [1, n] 范围内但没有出现在 nums 中的数字。
   *
   * @param nums 给定的整数数组
   * @return 返回缺失的数字列表
   */
  public List<Integer> findMissingNumbers(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>(); // 处理空数组的情况
    }

    int n = nums.length;
    boolean[] appeared = new boolean[n + 1]; // 初始化辅助数组

    // 标记每个数字是否出现过
    for (int num : nums) {
      if (num >= 1 && num <= n) { // 确保数字在合法范围内
        appeared[num] = true;
      }
    }

    // 收集未出现的数字
    List<Integer> missingNumbers = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (!appeared[i]) {
        missingNumbers.add(i);
      }
    }
    return missingNumbers;
  }
}
