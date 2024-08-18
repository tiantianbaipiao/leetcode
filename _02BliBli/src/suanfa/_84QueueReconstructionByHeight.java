package suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其
 * 中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 */
public class _84QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        // 对 people 按照身高降序排序，身高相同则按照前面人数升序排序
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> result = new ArrayList<>();
        // 遍历排序后的数组，将每个人按照其前面人数 ki 插入到结果数组的相应位置
        for (int[] person : people) {
            // 插入到索引为 person[1] 的位置
            result.add(person[1], person);
        }

        // 将结果转换为数组
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        _84QueueReconstructionByHeight solution = new _84QueueReconstructionByHeight();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] queue = solution.reconstructQueue(people);

        // 输出结果
        for (int[] q : queue) {
            System.out.println(Arrays.toString(q));
        }
    }
}
