/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，
 * 表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _39CanFinish {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adjacency = new ArrayList<>(numCourses);
    int[] indegrees = new int[numCourses];

    // 初始化邻接表和入度数组
    for (int i = 0; i < numCourses; i++) {
      adjacency.add(new ArrayList<>());
    }

    // 填充邻接表和入度数组
    for (int[] cp : prerequisites) {
      adjacency.get(cp[1]).add(cp[0]);
      indegrees[cp[0]]++;
    }

    // 使用队列进行拓扑排序
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegrees[i] == 0) {
        queue.offer(i);
      }
    }

    // 进行拓扑排序
    while (!queue.isEmpty()) {
      int prerequisite = queue.poll();
      numCourses--;

      for (int course : adjacency.get(prerequisite)) {
        if (--indegrees[course] == 0) {
          queue.offer(course);
        }
      }
    }

    return numCourses == 0;
  }

  public static void main(String[] args) {
    _39CanFinish solver = new _39CanFinish();
    int numCourses = 2;
    int[][] prerequisites = {{1, 0}};
    boolean result = solver.canFinish(numCourses, prerequisites);
    System.out.println(result); // 输出: true
  }
}

