/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
public class _55CanJump {
  public boolean canJump(int[] nums) {
    if (nums == null || nums.length == 0) return false;

    int maxReach = 0;

    for (int i = 0; i < nums.length; i++) {
      if (i > maxReach) return false; // 当前位置无法到达
      maxReach = Math.max(maxReach, i + nums[i]); // 更新最远可到达的位置
      if (maxReach >= nums.length - 1) return true; // 判断是否能到达最后一个位置
    }

    return false;
  }
}

