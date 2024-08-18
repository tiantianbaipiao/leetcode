import java.util.*;

/**
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i]
 * 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，
 * 请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 */

public class _83CalcEquation {

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    // 构建图
    Map<String, Map<String, Double>> graph = buildGraph(equations, values);

    // 查询结果数组
    double[] results = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      List<String> query = queries.get(i);
      String start = query.get(0);
      String end = query.get(1);

      // 如果起始节点或结束节点不存在于图中，直接返回 -1.0
      if (!graph.containsKey(start) || !graph.containsKey(end)) {
        results[i] = -1.0;
        continue;
      }

      // 广度优先搜索
      results[i] = bfs(graph, start, end);
    }
    return results;
  }

  // 构建图的方法
  private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
    Map<String, Map<String, Double>> graph = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
      List<String> equation = equations.get(i);
      String u = equation.get(0); // 起始节点
      String v = equation.get(1); // 结束节点
      double val = values[i]; // 权重

      // 添加边
      graph.computeIfAbsent(u, k -> new HashMap<>()).put(v, val);
      graph.computeIfAbsent(v, k -> new HashMap<>()).put(u, 1 / val);
    }
    return graph;
  }

  // 广度优先搜索的方法
  private double bfs(Map<String, Map<String, Double>> graph, String start, String end) {
    Queue<String> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    queue.offer(start);
    visited.add(start);
    double value = 1.0;

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String current = queue.poll();
        if (current.equals(end)) {
          return value;
        }
        for (Map.Entry<String, Double> entry : graph.get(current).entrySet()) {
          String next = entry.getKey();
          double weight = entry.getValue();
          if (!visited.contains(next)) {
            visited.add(next);
            queue.offer(next);
          }
          value *= weight;
        }
      }
      // 回溯
      if (graph.containsKey(start) && graph.get(start).containsKey(end)) {
        value /= graph.get(start).get(end);
      }
    }

    return -1.0;
  }

  public static void main(String[] args) {
    _83CalcEquation solution = new _83CalcEquation();
    List<List<String>> equations = Arrays.asList(
        Arrays.asList("a", "b"),
        Arrays.asList("b", "c")
    );
    double[] values = {2.0, 3.0};
    List<List<String>> queries = Arrays.asList(
        Arrays.asList("a", "c"),
        Arrays.asList("b", "a"),
        Arrays.asList("a", "e"),
        Arrays.asList("a", "a"),
        Arrays.asList("x", "x")
    );
    double[] results = solution.calcEquation(equations, values, queries);
    System.out.println(Arrays.toString(results));
  }
}


