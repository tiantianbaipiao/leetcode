import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * 计一个支持在平均时间复杂度 O(1) 下，执行以下操作的数据结构：
 */
public class _81RandomizedSet {
    private int[] nums;
    private HashMap<Integer, Integer> valToIndex;
    private Random rand;

    public _81RandomizedSet() {
        nums = new int[0];
        valToIndex = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        // 扩展数组并插入新元素
        nums = Arrays.copyOf(nums, nums.length + 1);
        nums[nums.length - 1] = val;
        valToIndex.put(val, nums.length - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        int index = valToIndex.get(val);
        int last = nums[nums.length - 1];

        // 将最后一个元素移到当前元素的位置
        nums[index] = last;
        valToIndex.put(last, index);

        // 删除最后一个元素
        nums = Arrays.copyOf(nums, nums.length - 1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = rand.nextInt(nums.length);
        return nums[randomIndex];
    }
}
