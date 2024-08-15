package suanfa;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class _44ProductExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    int length = nums.length;
    int[] answer = new int[length];

    // 左侧元素的乘积
    answer[0] = 1;
    for (int i = 1; i < length; i++) {
      answer[i] = nums[i - 1] * answer[i - 1];
    }

    // 右侧元素的乘积
    int R = 1;
    for (int i = length - 1; i >= 0; i--) {
      answer[i] = answer[i] * R;
      R *= nums[i];
    }

    return answer;
  }
}

