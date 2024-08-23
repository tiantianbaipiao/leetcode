package suanfa;

import java.util.Arrays;

/**
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。
 * 计算并返回该研究者的 h 指数。
 */
public class _16HIndex {
    public int hIndex(int[] citations) {
        // 首先对引用次数数组进行排序
        Arrays.sort(citations);

        // 初始化 H 指数为 0
        int hIndex = 0;

        // 从后向前遍历排序后的数组
        for (int i = citations.length - 1; i >= 0; i--) {
            // 当前论文的引用次数
            int citation = citations[i];

            // 计算当前论文的位置（从后往前数）
            int position = citations.length - i;

            // 如果当前论文的引用次数大于等于它的位置
            // 则说明至少有 position 篇论文被引用了至少 position 次
            if (citation >= position) {
                // 更新 H 指数
                hIndex = position;
            } else {
                // 如果当前论文的引用次数小于它的位置
                // 则不需要再继续往前遍历了，因为更前面的论文引用次数只会更少
                break;
            }
        }

        // 返回计算得到的 H 指数
        return hIndex;
    }
}
