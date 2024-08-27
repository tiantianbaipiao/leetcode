import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 */
public class _57LargestNumber {
    public static String largestNumber(int[] nums) {
        // 将整型数组转换为字符串数组
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        
        // 自定义比较器，用于比较两个字符串连接后的大小
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        };
        
        // 排序字符串数组
        Arrays.sort(strNums, comparator);
        
        // 构建结果字符串
        StringBuilder result = new StringBuilder();
        for (String numStr : strNums) {
            result.append(numStr);
        }
        
        // 如果结果字符串以"0"开头，则说明所有数字都是0
        if (result.charAt(0) == '0') {
            return "0";
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        // 测试数据
        int[] nums = {3, 30, 34, 5, 9};
        
        // 输出结果
        System.out.println(largestNumber(nums)); // 输出 "9534330"
    }
}
