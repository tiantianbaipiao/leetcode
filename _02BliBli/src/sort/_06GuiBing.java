package sort;

public class _06GuiBing {

  public static void mergeSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }

    mergeSort(arr, 0, arr.length - 1);
  }

  private static void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
      int mid = left + (right - left) / 2;

      // 递归地排序左半部分
      mergeSort(arr, left, mid);

      // 递归地排序右半部分
      mergeSort(arr, mid + 1, right);

      // 合并两个已排序的子数组
      merge(arr, left, mid, right);
    }
  }

  private static void merge(int[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    // 创建临时数组
    int[] L = new int[n1];
    int[] R = new int[n2];

    // 复制数据到临时数组 L[] 和 R[]
    for (int i = 0; i < n1; i++)
      L[i] = arr[left + i];
    for (int j = 0; j < n2; j++)
      R[j] = arr[mid + 1 + j];

    // 合并临时数组回 arr[]
    int i = 0, j = 0;
    int k = left;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }

    // 复制 L[] 的剩余元素
    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    // 复制 R[] 的剩余元素
    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }

  public static void main(String[] args) {
    int[] arr = {12, 11, 13, 5, 6, 7};
    System.out.println("Original array:");
    printArray(arr);

    mergeSort(arr);

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

