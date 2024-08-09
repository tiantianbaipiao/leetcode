package sort;

/**
 * 基数排序
 */
public class _10RadixSort {

  public static void radixSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }

    int max = getMax(arr);

    // 从最低位开始进行排序
    for (int exp = 1; max / exp > 0; exp *= 10) {
      countSort(arr, exp);
    }
  }

  private static void countSort(int[] arr, int exp) {
    int n = arr.length;
    int[] output = new int[n]; // 输出数组
    int[] count = new int[10]; // 计数数组

    // 计算每个位置的计数
    for (int i = 0; i < n; i++) {
      int index = (arr[i] / exp) % 10;
      count[index]++;
    }

    // 累加计数数组
    for (int i = 1; i < 10; i++) {
      count[i] += count[i - 1];
    }

    // 构建输出数组
    for (int i = n - 1; i >= 0; i--) {
      int index = (arr[i] / exp) % 10;
      output[count[index] - 1] = arr[i];
      count[index]--;
    }

    // 复制输出数组到原数组
    System.arraycopy(output, 0, arr, 0, n);
  }

  private static int getMax(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
    System.out.println("Original array:");
    printArray(arr);

    radixSort(arr);

    System.out.println("Sorted array:");
    printArray(arr);
  }

  private static void printArray(int[] arr) {
    for (int value : arr) {
      System.out.print(value + " ");
    }
    System.out.println();
  }
}

