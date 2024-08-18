import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
