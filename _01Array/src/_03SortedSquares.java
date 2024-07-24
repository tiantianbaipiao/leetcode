/**
 * 有序数组的平方
 */
public class _03SortedSquares {
  public static int[] sortedSquares(int[] nums) {
    // 定义左右指针
    int left = 0;
    int right = nums.length - 1;
    // 定义结果数组
    int[] result = new int[nums.length];
    // 拿到结果数组的索引
    int resIndex = nums.length - 1;
    while (left <= right){
      if(nums[right] * nums[right] > nums[left] * nums[left]){
        result[resIndex] = nums[right] * nums[right];
        right--;
        resIndex--;
      }else{
        result[resIndex] = nums[left] * nums[left];
        left++;
        resIndex--;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {-4,-1,0,3,10};
    int[] res = sortedSquares(nums);
    for (int i : res) {
      System.out.println(i);
    }
  }
}
