package sort;

/**
 * 快速排序
 */
public class _04KuaiSu {
  // 实现快速排序
  public static void quickSort(int[] arr, int low, int high) {
    if (arr == null || arr.length == 0)
      return;

    if (low >= high)
      return;

    // Partitioning index
    int partitionIndex = partition(arr, low, high);

    // Recursively sort elements before
    // partition and after partition
    quickSort(arr, low, partitionIndex - 1);
    quickSort(arr, partitionIndex + 1, high);
  }

  private static int partition(int[] array, int low, int high) {
    // Choosing the pivot
    int pivot = array[high];

    int i = (low - 1); // Index of smaller element

    for (int j = low; j < high; j++) {
      // If current element is smaller than the pivot
      if (array[j] < pivot) {
        i++;

        // Swap array[i] and array[j]
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }

    // Swap array[i+1] and array[high] (or pivot)
    int temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;

    return i + 1;
  }

  public static void main(String[] args) {
    int[] arr = { 10, 7, 8, 9, 1, 5 };
    quickSort(arr, 0, arr.length - 1);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}

