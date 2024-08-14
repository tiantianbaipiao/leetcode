package suanfa;

import java.util.Arrays;

/**
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表，用字母 A 到 Z 表示，以及一个冷却时间 n。
 * 每个周期或时间间隔允许完成一项任务。任务可以按任何顺序完成，但有一个限制：两个 相同种类 的任务之间必须有长度为 n 的冷却时间。
 * 返回完成所有任务所需要的 最短时间间隔
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 */
import java.util.Arrays;

public class _36LeastInterval {
  public int leastInterval(char[] tasks, int n) {
    // Step 1: Count the frequency of each task
    int[] counts = new int[26];
    for (char c : tasks) {
      counts[c - 'A']++;
    }

    // Step 2: Find the max count and how many tasks have this max count
    int maxCount = Arrays.stream(counts).max().orElse(0);
    int maxCountTasks = (int) Arrays.stream(counts).filter(count -> count == maxCount).count();

    // Step 3: Calculate the total required intervals
    int totalParts = (maxCount - 1) * (n + 1) + maxCountTasks;

    // Ensure the total parts are at least as many as the tasks
    return Math.max(totalParts, tasks.length);
  }

  public static void main(String[] args) {
    _36LeastInterval scheduler = new _36LeastInterval();
    char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
    int n = 2;
    System.out.println(scheduler.leastInterval(tasks, n)); // Output: 8
  }
}


