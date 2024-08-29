import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s 和一个整数 k，找出该字符串中至少有 k 个重复字符的最长子串的长度。
 */
public class _84LongestSubstring {
    public int longestSubstring(String s, int k) {
        return longestSubstringHelper(s, 0, s.length() - 1, k);
    }

    private int longestSubstringHelper(String s, int left, int right, int k) {
        if (left > right) {
            return 0;
        }

        // 统计每个字符的出现次数
        Map<Character, Integer> count = new HashMap<>();
        for (int i = left; i <= right; i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }

        // 找到不符合条件的字符
        for (int i = left; i <= right; i++) {
            char c = s.charAt(i);
            if (count.get(c) < k) {
                // 分割字符串并递归处理
                int split = i;
                int leftResult = longestSubstringHelper(s, left, split - 1, k);
                int rightResult = longestSubstringHelper(s, split + 1, right, k);
                return Math.max(leftResult, rightResult);
            }
        }

        // 所有字符都符合条件
        return right - left + 1;
    }
}
