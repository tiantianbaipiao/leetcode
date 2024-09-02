import java.util.*;

public class _123MinMutation {

    /**
     * 计算最小基因变化次数
     * @param start 起始基因序列
     * @param end 目标基因序列
     * @param bank 基因库
     * @return 最小基因变化次数
     */
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) {
            return -1; // 目标基因不在基因库中
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(start);
        visited.add(start);
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(end)) {
                    return steps;
                }

                // 尝试变换一个字符
                for (int j = 0; j < 8; j++) {
                    char[] chars = {'A', 'C', 'G', 'T'};
                    for (char c : chars) {
                        if (c == current.charAt(j)) {
                            continue;
                        }

                        StringBuilder sb = new StringBuilder(current);
                        sb.setCharAt(j, c);
                        String next = sb.toString();

                        if (bankSet.contains(next) && !visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }

            steps++; // 增加步数
        }

        return -1; // 无法到达目标基因
    }

    // 测试方法
    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};

        _123MinMutation solution = new _123MinMutation();
        int result = solution.minMutation(start, end, bank);
        System.out.println(result); // 应输出 1
    }
}
