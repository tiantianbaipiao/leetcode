package suanfa;

import java.util.Stack;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 */
public class _30SortArray {
  public static void main(String[] args) {
    int[] nums = {5, 2, 9, 1, 5, 6};
    int[] sortedNums = sortArray(nums);

    // 输出排序后的数组
    for (int num : sortedNums) {
      System.out.print(num + " ");
    }
  }

  public static int[] sortArray(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
    return nums;
  }

  private static void quickSort(int[] arr, int low, int high) {
    if (arr == null || arr.length == 0) {
      return;
    }
    if (low < 0 || high >= arr.length || low > high) {
      throw new IllegalArgumentException("Invalid parameters: low and high must be within array bounds.");
    }

    Stack<Integer> stack = new Stack<>();
    stack.push(low);
    stack.push(high);

    while (!stack.isEmpty()) {
      high = stack.pop();
      low = stack.pop();

      if (low < high) {
        int partitionIndex = partition(arr, low, high);
        stack.push(low);
        stack.push(partitionIndex - 1);
        stack.push(partitionIndex + 1);
        stack.push(high);
      }
    }
  }


  private static int partition(int[] arr, int low, int high) {
    // 验证输入
    if (arr == null || arr.length == 0 || low > high) {
      throw new IllegalArgumentException("Invalid input parameters");
    }

    // 选择基准值
    int pivotIndex = choosePivot(arr, low, high);
    swap(arr, pivotIndex, high); // 将基准值移到末尾

    int smallerIndex = low - 1; // 索引指向比基准值小的元素

    for (int currentIndex = low; currentIndex < high; currentIndex++) {
      // 如果当前元素小于或等于基准值
      if (arr[currentIndex] <= arr[high]) {
        smallerIndex++;

        // 交换 arr[smallerIndex] 和 arr[currentIndex]
        swap(arr, smallerIndex, currentIndex);
      }
    }

    // 交换 arr[smallerIndex + 1] 和 arr[high] (即基准值)
    swap(arr, smallerIndex + 1, high);

    return smallerIndex + 1;
  }

  // 选择一个更好的基准值
  private static int choosePivot(int[] arr, int low, int high) {
    int mid = (low + high) / 2;
    if (arr[low] > arr[mid]) swap(arr, low, mid);
    if (arr[low] > arr[high]) swap(arr, low, high);
    if (arr[mid] > arr[high]) swap(arr, mid, high);
    return mid; // 返回中间值的索引
  }

  // 通用的交换方法
  private static void swap(int[] arr, int index1, int index2) {
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }

}

