import java.util.Arrays;

/**
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 */

public class _103MinArrows {

    /**
     * 计算最少数量的箭来戳破所有气球。
     * @param points 气球的坐标范围
     * @return 最少数量的箭
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        // 按照右端点从小到大排序
        Arrays.sort(points, (a, b) -> a[1] - b[1]);

        int arrows = 1; // 至少需要一支箭
        int end = points[0][1]; // 第一个气球的右端点

        for (int[] point : points) {
            int left = point[0];
            int right = point[1];

            // 如果当前气球的左端点大于前一个气球的右端点
            if (left > end) {
                arrows++; // 需要一支新的箭
                end = right; // 更新右端点
            } else {
                // 如果当前气球的右端点更小，则更新右端点
                end = Math.min(end, right);
            }
        }

        return arrows;
    }

    // 测试方法
    public static void main(String[] args) {
        _103MinArrows solution = new _103MinArrows();

        int[][] points1 = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        int result1 = solution.findMinArrowShots(points1);
        System.out.println(result1);  // 输出 2

        int[][] points2 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int result2 = solution.findMinArrowShots(points2);
        System.out.println(result2);  // 输出 2

        int[][] points3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}};
        int result3 = solution.findMinArrowShots(points3);
        System.out.println(result3);  // 输出 2
    }
}

