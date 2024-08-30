package suanfa;

/**
 * 要求找到最少的跳跃次数以到达数组的最后一个位置
 */
public class _87Jump {
    public int jump(int[] nums) {
        // 如果数组为空或长度为0，直接返回0
        if (nums == null || nums.length == 0) return 0;

        // 初始化跳跃次数
        int jumps = 0;
        // 当前能够达到的最大位置
        int currentEnd = 0;
        // 下一步能够达到的最大位置
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) { // 注意循环条件，不包括最后一个位置
            // 更新下一步能够达到的最大位置
            farthest = Math.max(farthest, i + nums[i]);

            // 如果当前位置已经达到了当前能够达到的最大位置
            if (i == currentEnd) {
                // 更新跳跃次数
                jumps++;
                // 更新当前能够达到的最大位置
                currentEnd = farthest;

                // 如果当前能够达到的最大位置已经超过了数组的最后一个位置
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        // 返回跳跃次数
        return jumps;
    }
}
