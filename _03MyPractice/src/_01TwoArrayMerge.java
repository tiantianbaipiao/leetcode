import java.util.Arrays;

public class _01TwoArrayMerge {
  // method 1
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    // 把nums2 放到 nums1 的后面，然后对 nums1 进行排序
    for (int i = 0; i < nums2.length; i++){
      nums1[m + i] = nums2[i];
    }
    Arrays.sort(nums1);
  }
  // method 2 双指针
  public void merge2(int[] nums1, int m, int[] nums2, int n) {

  }

  public static void main(String[] args) {
    _01TwoArrayMerge t = new _01TwoArrayMerge();
    int[] nums1 = {1,2,3,0,0,0};
    int[] nums2 = {2,5,6};
    t.merge(nums1, 3, nums2, 3);
    System.out.println(Arrays.toString(nums1));
  }
}
