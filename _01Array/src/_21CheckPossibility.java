/**
 * 给你一个长度为 n 的整数数组 nums ，
 *
 * 请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 */
public class _21CheckPossibility {
  public boolean checkPossibility(int[] nums) {
    // 初始化修改次数为 0
    int modifications = 0;

    // 遍历数组中的每个元素
    for (int i = 1; i < nums.length; i++) {
      // 如果当前元素小于前一个元素，则需要修改
      if (nums[i] < nums[i - 1]) {
        // 如果已经修改过一次，则无法通过修改变成非递减数列
        if (modifications == 1) {
          return false;
        }

        // 增加修改次数
        modifications++;

        // 检查两种可能的情况：
        // 1. 将当前元素修改为前一个元素的值
        // 2. 将前一个元素修改为当前元素的值
        // 如果这两种情况之一可以使序列变成非递减数列，则继续
        // 否则，无法通过修改变成非递减数列
        if ((i - 2 >= 0 && nums[i - 2] > nums[i]) && (i + 1 < nums.length && nums[i - 1] > nums[i + 1])) {
          return false;
        }
      }
    }

    // 如果能通过最多一次修改变成非递减数列，则返回 true
    return true;
  }
}

