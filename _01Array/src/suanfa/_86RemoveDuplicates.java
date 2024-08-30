package suanfa;

/**
 * 要求是在一个已排序的数组中删除重复项，
 * 使得每个元素最多出现两次，并返回新的长度。我们可以使用双指针技术来解决这个问题
 */
public class _86RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        // 如果数组为空或长度为0，直接返回0
        if (nums == null || nums.length == 0) return 0;
        
        // 初始化两个指针
        int count = 1; // 用来记录当前元素出现的次数
        int j = 1; // 指向数组中可以被覆盖的位置
        
        // 从数组的第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            // 如果当前元素与前一个元素相同
            if (nums[i] == nums[i - 1]) {
                // 增加计数
                count++;
                
                // 如果当前元素出现次数小于等于2，则移动j指针并更新数组
                if (count <= 2) {
                    nums[j] = nums[i];
                    j++;
                }
            } else {
                // 如果当前元素与前一个元素不同，重置计数器并更新数组
                nums[j] = nums[i];
                j++;
                count = 1;
            }
        }
        
        // 返回新的有效长度
        return j;
    }
}
