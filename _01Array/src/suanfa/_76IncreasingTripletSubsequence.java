package suanfa;

/**
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 */
public class _76IncreasingTripletSubsequence {

    /**
     * 判断一个整数数组中是否存在递增的三元子序列
     * @param nums 给定的整数数组
     * @return 如果存在递增的三元子序列，则返回 true；否则返回 false
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        // 定义两个变量 first 和 second，分别表示已找到的第一个递增元素和第二个递增元素
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            // 如果当前元素小于 first，则更新 first
            if (num <= first) {
                first = num;
            }
            // 如果当前元素大于 first 且小于 second，则更新 second
            else if (num <= second) {
                second = num;
            }
            // 如果当前元素大于 second，则找到了递增的三元子序列
            else {
                return true;
            }
        }

        // 没有找到递增的三元子序列
        return false;
    }

    public static void main(String[] args) {
        _76IncreasingTripletSubsequence solution = new _76IncreasingTripletSubsequence();

        // 测试数据
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {5, 4, 3, 2, 1};
        int[] nums3 = {2, 1, 5, 0, 4, 6};

        // 输出结果
        System.out.println("是否存在递增的三元子序列？ " + solution.increasingTriplet(nums1)); // true
        System.out.println("是否存在递增的三元子序列？ " + solution.increasingTriplet(nums2)); // false
        System.out.println("是否存在递增的三元子序列？ " + solution.increasingTriplet(nums3)); // true
    }
}
