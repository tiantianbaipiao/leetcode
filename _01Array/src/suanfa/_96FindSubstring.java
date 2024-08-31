package suanfa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 *
 *  s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 */
public class _96FindSubstring {

    /**
     * 找出所有由 words 中的单词组成的 s 中的连续子串。
     * @param s 给定的字符串
     * @param words 字符串列表
     * @return 返回所有符合条件的起始索引
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return result;
        }

        int wordCount = words.length;  // 单词数量
        int wordLength = words[0].length();  // 单词长度
        int totalLength = wordCount * wordLength;  // 总长度

        Map<String, Integer> wordFrequency = new HashMap<>();  // 单词频率统计
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        for (int start = 0; start < wordLength; start++) {
            Map<String, Integer> seenWords = new HashMap<>();  // 已经看到的单词
            int count = 0;  // 已经匹配的单词数量
            int left = start;  // 左边界
            int right = start;  // 右边界

            while (right + wordLength <= s.length()) {
                String currentWord = s.substring(right, right + wordLength);
                right += wordLength;

                if (wordFrequency.containsKey(currentWord)) {
                    seenWords.put(currentWord, seenWords.getOrDefault(currentWord, 0) + 1);
                    count++;

                    while (seenWords.get(currentWord) > wordFrequency.get(currentWord)) {
                        String removeWord = s.substring(left, left + wordLength);
                        seenWords.put(removeWord, seenWords.get(removeWord) - 1);
                        left += wordLength;
                        count--;
                    }

                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    seenWords.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }

    // 测试方法
    public static void main(String[] args) {
        _96FindSubstring solution = new _96FindSubstring();
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> result = solution.findSubstring(s, words);
        System.out.println(result);
    }
}
