import java.util.PriorityQueue;

public class _70MedianFinder {
    // 最大堆存储较小的一半数字
    private PriorityQueue<Integer> maxHeap;
    
    // 最小堆存储较大的一半数字
    private PriorityQueue<Integer> minHeap;

    public _70MedianFinder() {
        // 创建最大堆
        maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // 创建最小堆
        minHeap = new PriorityQueue<>();
    }

    /**
     * 添加一个数字到数据结构中
     * @param num 新添加的数字
     */
    public void addNum(int num) {
        // 如果最大堆为空或新数字小于最大堆的堆顶元素，则添加到最大堆
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // 保持两个堆的平衡
        balanceHeaps();
    }

    /**
     * 保持两个堆的平衡
     */
    private void balanceHeaps() {
        // 如果最大堆比最小堆多两个元素，则将最大堆的一个元素移到最小堆
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }

        // 如果最小堆比最大堆多一个元素，则将最小堆的一个元素移到最大堆
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    /**
     * 获取当前所有数字的中位数
     * @return 当前所有数字的中位数
     */
    public double findMedian() {
        // 如果两个堆大小相同，则取两个堆顶元素的平均值
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        // 否则返回最大堆的堆顶元素
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        _70MedianFinder finder = new _70MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian()); // 输出 1.5

        finder.addNum(3);
        System.out.println(finder.findMedian()); // 输出 2.0
    }
}
