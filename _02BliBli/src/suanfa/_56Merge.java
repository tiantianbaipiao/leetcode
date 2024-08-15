package suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间
 */
public class _56Merge {
  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0) return new int[0][2];

    // 按照起始位置排序
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    List<int[]> merged = new ArrayList<>();
    int[] currentInterval = intervals[0];
    merged.add(currentInterval);

    for (int[] interval : intervals) {
      if (interval[0] <= currentInterval[1]) { // 有重叠
        currentInterval[1] = Math.max(currentInterval[1], interval[1]); // 合并区间
      } else { // 没有重叠
        currentInterval = interval;
        merged.add(currentInterval);
      }
    }

    return merged.toArray(new int[merged.size()][]);
  }
}

