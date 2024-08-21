package suanfa;

/**
 * 删除元素
 */
public class _02RemoveElement {
  // 快慢指针法
  public static int removeElement(int[] nums, int val) {
    // 定义慢指针
    int slow = 0;
    // 遍历数组
    for (int fast = 0; fast < nums.length; fast++){
      if(nums[fast] != val){
        nums[slow] = nums[fast];
        slow++;
      }
    }
    return slow;
  }

  public static void main(String[] args) {
    int[] nums = {0,1,2,2,3,0,4,2};
    System.out.println(removeElement(nums, 2));
  }
}
