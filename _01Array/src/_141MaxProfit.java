import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _141MaxProfit {

    /**
     * 在一场 IPO 中选择一些项目进行投资，使得总利润最大化。
     *
     * @param k      最多可以选择的项目数量
     * @param w      初始资本
     * @param profits 每个项目的利润
     * @param capital 每个项目的成本
     * @return 最大化后的总利润
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // 将项目按照成本从小到大排序
        Project[] projects = new Project[profits.length];
        for (int i = 0; i < profits.length; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }
        Arrays.sort(projects, Comparator.comparingInt(Project::getCapital));

        // 使用优先队列（大顶堆）来存储当前可投资的项目
        PriorityQueue<Project> availableProjects = new PriorityQueue<>((a, b) -> b.getProfit() - a.getProfit());

        // 当前可用资本
        int currentCapital = w;

        // 选择 k 个项目进行投资
        for (int i = 0; i < k; i++) {
            // 将所有当前可用的项目加入 availableProjects
            while (currentCapital >= projects[i].getCapital()) {
                availableProjects.offer(projects[i]);
                i++;
                if (i == projects.length) break;
            }

            // 如果没有可用项目，则退出循环
            if (availableProjects.isEmpty()) break;

            // 选择当前利润最大的项目进行投资
            Project bestProject = availableProjects.poll();
            currentCapital += bestProject.getProfit();
        }

        return currentCapital;
    }

    private static class Project {
        private final int capital;
        private final int profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        public int getCapital() {
            return capital;
        }

        public int getProfit() {
            return profit;
        }
    }

    public static void main(String[] args) {
        _141MaxProfit solution = new _141MaxProfit();

        // 测试用例
        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};
        System.out.println(solution.findMaximizedCapital(k, w, profits, capital)); // 输出应为 4

        k = 3;
        w = 0;
        profits = new int[]{1, 2, 3};
        capital = new int[]{0, 1, 2};
        System.out.println(solution.findMaximizedCapital(k, w, profits, capital)); // 输出应为 6

        k = 2;
        w = 0;
        profits = new int[]{1, 2, 3};
        capital = new int[]{1, 1, 2};
        System.out.println(solution.findMaximizedCapital(k, w, profits, capital)); // 输出应为 5
    }
}
