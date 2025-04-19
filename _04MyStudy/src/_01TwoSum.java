import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum/
 * @author Lixiaoshuang
 * @date 2025/04/19
 * @descrption
 */
public class _01TwoSum {
  // 暴力求解
  public int[] twoSum (int nums[], int target){
    int[] res = new int[2];
    for(int i = 0; i < nums.length; i++){
      for(int j = 1; j < nums.length; j++){
        if(target == nums[i]+nums[j]){
          res[0] = i;
          res[1] = j;
          return res;
        }
      }
    }
    return null;
  }
  // 优化方案
  public int[] twoSum_1 (int nums[], int target){
    int[] res = new int[2];
    for(int i = 0; i < nums.length; i++){
      for(int j = 1; j < nums.length; j++){
        if(target == nums[i]+nums[j]){
          res[0] = i;
          res[1] = j;
          return res;
        }
      }
    }
    return null;
  }
  public static void main(String[] args) {
    _01TwoSum method = new _01TwoSum();
    int[] nums = {3, 2, 4};
    int target = 6;
    int res[] = method.twoSum(nums, target);
    System.out.println(Arrays.toString(res));
  }
}
