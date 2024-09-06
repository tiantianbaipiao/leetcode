import java.util.ArrayList;
import java.util.List;

public class _144GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        generateGrayCode(result, n);
        return result;
    }

    private void generateGrayCode(List<Integer> result, int n) {
        if (n == 0) {
            result.add(0); // 基本情况：n=0 时只有一个元素 0
            return;
        }

        // 递归生成 n-1 位的格雷编码
        generateGrayCode(result, n - 1);

        // 计算当前位的值
        int currentBit = 1 << (n - 1);

        // 逆序添加新元素
        int size = result.size();
        for (int i = size - 1; i >= 0; i--) {
            int newValue = result.get(i) + currentBit;
            result.add(newValue);
        }
    }

    public static void main(String[] args) {
        _144GrayCode solution = new _144GrayCode();
        int n = 2;
        List<Integer> grayCodes = solution.grayCode(n);
        System.out.println(grayCodes); // 输出 [0, 1, 3, 2]
    }
}
