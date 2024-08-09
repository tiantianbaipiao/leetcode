package sort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序
 */


public class _09BucketSort {

  public static void bucketSort(float[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }

    // 确定桶的数量
    int numberOfBuckets = (int) Math.sqrt(arr.length);
    float maxValue = findMaxValue(arr);

    // 创建桶
    List<List<Float>> buckets = new ArrayList<>(numberOfBuckets);
    for (int i = 0; i < numberOfBuckets; i++) {
      buckets.add(new ArrayList<>());
    }

    // 分配元素到桶中
    for (float value : arr) {
      int index = (int) ((value / maxValue) * (numberOfBuckets - 1));
      buckets.get(index).add(value);
    }

    // 对每个桶进行排序
    int index = 0;
    for (List<Float> bucket : buckets) {
      Collections.sort(bucket); // 使用内置排序方法
      for (float value : bucket) {
        arr[index++] = value;
      }
    }
  }

  private static float findMaxValue(float[] arr) {
    float maxValue = Float.MIN_VALUE;
    for (float value : arr) {
      if (value > maxValue) {
        maxValue = value;
      }
    }
    return maxValue;
  }

  public static void main(String[] args) {
    float[] arr = {0.78f, 0.17f, 0.39f, 0.26f, 0.72f, 0.94f, 0.21f, 0.12f, 0.23f, 0.68f};
    System.out.println("Original array:");
    printArray(arr);

    bucketSort(arr);

    System.out.println("Sorted array:");
    printArray(arr);
  }

  private static void printArray(float[] arr) {
    for (float value : arr) {
      System.out.printf("%.2f ", value);
    }
    System.out.println();
  }
}

