package suanfa;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个正整数 n，输出从 1 到 n 的数字，但是：
 * 能被 3 整除的数字替换成 "Fizz"；
 * 能被 5 整除的数字替换成 "Buzz"；
 * 能同时被 3 和 5 整除的数字替换成 "FizzBuzz"。
 */
public class _85FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        
        // 遍历从 1 到 n 的每一个数字
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        
        return result;
    }
}
