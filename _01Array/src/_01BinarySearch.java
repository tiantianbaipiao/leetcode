/**
 * 二分查找
 */
public class _01BinarySearch {
  public static int binarySearch(int[] arr, int target) {
    // target 定义在左闭右闭区间
    // 定义左右指针
    int left = 0;
    int right = arr.length - 1;
    while (left <= right){
      int middle = (left + right) / 2;
      if(target < arr[middle]){
        right = middle-1;
      }else if(target > arr[middle]){
        left = middle+1;
      }else {
        return middle;
      }
    }
    return -1;
  }
  public static void main(String[] args) {
    int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
    int target = 5;
    System.out.println(binarySearch(arr, target));
  }
}
