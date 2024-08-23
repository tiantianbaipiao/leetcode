import java.util.ArrayList;
import java.util.List;

/**
 * 数组中重复的数据 要求找出数组中所有重复的数字。
 */
public class _15findDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // 遍历数组中的每个元素
        for (int i = 0; i < nums.length; i++) {
            // 计算当前元素应该在数组中的位置
            int index = Math.abs(nums[i]) - 1;
            // 检查该位置上的元素是否已经是负数
            if (nums[index] < 0) {
                // 如果已经是负数，则说明该数字已经出现过一次，添加到结果列表
                result.add(index + 1);
            } else {
                // 否则，将该位置上的元素标记为负数
                nums[index] = -nums[index];
            }
        }

        return result;
    }
}
