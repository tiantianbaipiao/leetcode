package sort;

/**
 * 希尔排序
 */
public class _05XiEr {
  // 希尔排序
  public static void shellSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }

    int n = arr.length;
    int gap = n / 2; // 初始增量

    while (gap > 0) {
      for (int i = gap; i < n; i++) {
        int temp = arr[i];
        int j = i;
        // 插入排序
        while (j >= gap && arr[j - gap] > temp) {
          arr[j] = arr[j - gap];
          j -= gap;
        }
        arr[j] = temp;
      }
      // 减小增量
      gap /= 2;
    }
  }

  public static void main(String[] args) {
    int[] arr = {8, 9, 1, 7, 2, 3, 5, 6, 4};
    shellSort(arr);
    System.out.println("Sorted array: ");
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }
}

