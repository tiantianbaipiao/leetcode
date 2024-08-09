package sort;

/**
 * 计数排序
 */
public class _08JiShu {

  public static void countingSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    // 找到数组中的最大值和最小值
    for (int value : arr) {
      if (value > max) {
        max = value;
      }
      if (value < min) {
        min = value;
      }
    }

    int range = max - min + 1;
    int[] count = new int[range];
    int[] output = new int[arr.length];

    // 计算每个元素出现的次数
    for (int value : arr) {
      count[value - min]++;
    }

    // 累加 count 数组
    for (int i = 1; i < count.length; i++) {
      count[i] += count[i - 1];
    }

    // 构建输出数组
    for (int i = arr.length - 1; i >= 0; i--) {
      output[count[arr[i] - min] - 1] = arr[i];
      count[arr[i] - min]--;
    }

    // 复制排序后的数组到原数组
    System.arraycopy(output, 0, arr, 0, arr.length);
  }

  public static void main(String[] args) {
    int[] arr = {4, 2, 2, 8, 3, 3, 1};
    System.out.println("Original array:");
    printArray(arr);

    countingSort(arr);

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

