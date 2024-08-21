/**
 * 给你一个 非递减 的整数数组 timeSeries ，其中 timeSeries[i] 表示提莫在 timeSeries[i] 秒时对艾希发起攻击，以及一个表示中毒持续时间的整数 duration 。
 *
 * 返回艾希处于中毒状态的 总 秒数。
 */
public class _10FindPoisonedDuration {
  public int findPoisonedDuration(int[] timeSeries, int duration) {
    if (timeSeries.length == 0) {
      return 0;
    }

    int totalDuration = 0;
    for (int i = 0; i < timeSeries.length - 1; i++) {
      // 如果下一次攻击发生在当前中毒时间内，则更新中毒时间
      int gap = timeSeries[i + 1] - timeSeries[i];
      if (gap < duration) {
        totalDuration += gap;
      } else {
        totalDuration += duration;
      }
    }

    // 最后一次攻击总是会加上完整的 duration 时间
    totalDuration += duration;

    return totalDuration;
  }

  // 测试函数
  public static void main(String[] args) {
    _10FindPoisonedDuration solution = new _10FindPoisonedDuration();
    int[] timeSeries = {1, 4};
    int duration = 2;
    System.out.println(solution.findPoisonedDuration(timeSeries, duration)); // 应输出 4
  }
}

