import java.util.*;

public class _82TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        // 统计每个元素出现的次数
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // 使用优先队列（最小堆）来保存出现频率最高的 k 个元素
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll(); // 当队列大小超过 k 时，弹出最小的元素
            }
        }

        // 从堆中提取结果
        int[] result = new int[k];
        int index = 0;
        while (!pq.isEmpty()) {
            result[index++] = pq.poll().getKey();
        }

        // 反转数组以确保结果是从高到低排列
        reverseArray(result);

        return result;
    }

    // 反转数组
    private void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
