import java.util.Random;

/**
 * 力扣题目 384：打乱数组
 */
public class _82ShuffleArray {
    private int[] original;
    private int[] current;
    private Random rand;

    public _82ShuffleArray(int[] nums) {
        original = nums;
        current = nums.clone();
        rand = new Random();
    }

    public int[] reset() {
        current = original.clone();
        return current;
    }

    public int[] shuffle() {
        for (int i = 0; i < current.length; i++) {
            // 生成一个随机索引
            int randomIndex = i + rand.nextInt(current.length - i);

            // 交换元素
            int temp = current[i];
            current[i] = current[randomIndex];
            current[randomIndex] = temp;
        }
        return current;
    }
}
