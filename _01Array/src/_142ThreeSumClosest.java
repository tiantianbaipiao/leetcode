import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。
 * 请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 */
public class _142ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        // 对数组进行排序
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2]; // 初始化最接近的和为前三个数之和
        for (int i = 0; i < nums.length - 2; i++) {
            // 双指针初始化
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                // 如果当前和等于目标值，则直接返回
                if (currentSum == target) {
                    return currentSum;
                }
                // 更新最接近的和
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }
                // 根据当前和与目标值的关系移动指针
                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        _142ThreeSumClosest solution = new _142ThreeSumClosest();
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(solution.threeSumClosest(nums, target)); // 输出 2，因为 (-1 + 2 + 1) = 2 是离 1 最近的和
    }
}
