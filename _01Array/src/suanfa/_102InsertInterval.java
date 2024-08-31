package suanfa;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。
 * 同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 */
public class _102InsertInterval {

    /**
     * 将新的区间插入到区间列表中，并返回合并后的区间列表。
     * @param intervals 区间列表
     * @param newInterval 新的区间
     * @return 合并后的区间列表
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();

        int start = newInterval[0];
        int end = newInterval[1];
        boolean merged = false;

        for (int[] interval : intervals) {
            if (interval[1] < start) {
                // 当前区间完全在新区间之前
                mergedIntervals.add(interval);
            } else if (interval[0] > end) {
                // 当前区间完全在新区间之后
                if (!merged) {
                    mergedIntervals.add(new int[]{start, end});
                    merged = true;
                }
                mergedIntervals.add(interval);
            } else {
                // 当前区间与新区间有交集
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }

        // 如果新区间没有被合并，则单独添加新区间
        if (!merged) {
            mergedIntervals.add(new int[]{start, end});
        }

        // 转换为数组形式
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    // 测试方法
    public static void main(String[] args) {
        _102InsertInterval solution = new _102InsertInterval();

        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        int[][] result1 = solution.insert(intervals1, newInterval1);
        printIntervals(result1);  // 输出 [[1, 5], [6, 9]]

        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        int[][] result2 = solution.insert(intervals2, newInterval2);
        printIntervals(result2);  // 输出 [[1, 2], [3, 10], [12, 16]]
    }

    /**
     * 打印区间列表。
     * @param intervals 区间列表
     */
    private static void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
        System.out.println();
    }
}
