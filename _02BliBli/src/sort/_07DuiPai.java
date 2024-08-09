package sort;

/**
 * 堆排序
 */
public class _07DuiPai {

  public static void heapSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }

    int n = arr.length;

    // 构建最大堆
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(arr, n, i);
    }

    // 一个个从堆顶取出元素
    for (int i = n - 1; i > 0; i--) {
      // 将当前根（最大值）移动到末尾
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      // 调用 heapify 修复新的未排序部分
      heapify(arr, i, 0);
    }
  }

  private static void heapify(int[] arr, int n, int i) {
    int largest = i; // 初始化最大值索引
    int left = 2 * i + 1; // 左子节点索引
    int right = 2 * i + 2; // 右子节点索引

    // 如果左子节点大于根
    if (left < n && arr[left] > arr[largest]) {
      largest = left;
    }

    // 如果右子节点大于当前最大值
    if (right < n && arr[right] > arr[largest]) {
      largest = right;
    }

    // 如果最大值不是根
    if (largest != i) {
      int swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;

      // 递归地调整受影响的子树
      heapify(arr, n, largest);
    }
  }

  public static void main(String[] args) {
    int[] arr = {12, 11, 13, 5, 6, 7};
    System.out.println("Original array:");
    printArray(arr);

    heapSort(arr);

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

