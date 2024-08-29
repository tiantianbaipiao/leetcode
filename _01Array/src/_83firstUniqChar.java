import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个字符串 s，找到它的第一个不重复的字符，并返回它的索引。如果不存在这样的字符，则返回 -1。
 */
public class _83firstUniqChar {
    public int firstUniqChar(String s) {
        // 使用哈希表记录每个字符出现的次数
        Map<Character, Integer> charCount = new HashMap<>();

        // 第一遍遍历字符串，统计每个字符出现的次数
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // 第二遍遍历字符串，找到第一个只出现一次的字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charCount.get(c) == 1) {
                return i;
            }
        }

        // 如果没有找到唯一的字符，返回 -1
        return -1;
    }
}
