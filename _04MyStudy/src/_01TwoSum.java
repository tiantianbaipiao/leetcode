import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 * @author Lixiaoshuang
 * @date 2025/04/19
 * @descrption 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 */
public class _01TwoSum {
  // 暴力求解
  public int[] twoSum (int nums[], int target){
    int[] res = new int[2];
    for(int i = 0; i < nums.length; i++){
      for(int j = i+1; j < nums.length; j++){
        if(target == nums[i]+nums[j]){
          res[0] = i;
          res[1] = j;
          return res;
        }
      }
    }
    return null;
  }
  // 优化方案 哈希表
  public int[] twoSum_1 (int nums[], int target){
    // 利用哈希表键值对唯一的特性把数组存入哈希表（K：数组值，V：下标）
    // 判断哈希表中是否存在target-K等于V的情况，如果有则put出来K与V
    // 1. 创建hashtable
    Map<Integer, Integer> hashTable = new HashMap<>();
    //2. 存入hashtable
    for (int i = 0; i< nums.length; i++){
      // 3.判断hashtable中是否有满足条件的，没有则存入hashtable
      if(hashTable.containsKey(target-nums[i])){
        return new int[]{hashTable.get(target-nums[i]),i};
      }
      hashTable.put(nums[i], i);
    }
    return null;
  }
  public static void main(String[] args) {
    _01TwoSum method = new _01TwoSum();
    int[] nums = {2, 7, 11, 5};
    int target = 9;
    int res[] = method.twoSum(nums, target);
    System.out.println(Arrays.toString(res));
  }
}
