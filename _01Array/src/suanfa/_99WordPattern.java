package suanfa;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 */
public class _99WordPattern {

    /**
     * 判断字符串 s 是否遵循模式 pattern。
     * @param pattern 模式字符串
     * @param s 输入字符串
     * @return 如果 s 遵循模式 pattern，返回 true；否则返回 false
     */
    public boolean wordPattern(String pattern, String s) {
        // 将输入字符串 s 分割成单词列表
        StringTokenizer st = new StringTokenizer(s);
        if (st.countTokens() != pattern.length()) {
            return false;
        }

        Map<String, Character> wordToChar = new HashMap<>();
        Map<Character, String> charToWord = new HashMap<>();

        int index = 0;
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            char p = pattern.charAt(index);

            // 检查单词是否已经被映射到模式中的字符
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != p) {
                    return false;
                }
            } else {
                wordToChar.put(word, p);
            }

            // 检查模式中的字符是否已经被映射到单词
            if (charToWord.containsKey(p)) {
                if (!charToWord.get(p).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(p, word);
            }

            index++;
        }

        return true;
    }

    // 测试方法
    public static void main(String[] args) {
        _99WordPattern solution = new _99WordPattern();
        String pattern1 = "abba";
        String s1 = "dog cat cat dog";
        boolean result1 = solution.wordPattern(pattern1, s1);
        System.out.println(result1);  // 输出 true

        String pattern2 = "abba";
        String s2 = "dog cat cat fish";
        boolean result2 = solution.wordPattern(pattern2, s2);
        System.out.println(result2);  // 输出 false

        String pattern3 = "aaaa";
        String s3 = "dog cat cat dog";
        boolean result3 = solution.wordPattern(pattern3, s3);
        System.out.println(result3);  // 输出 false

        String pattern4 = "abba";
        String s4 = "dog dog dog dog";
        boolean result4 = solution.wordPattern(pattern4, s4);
        System.out.println(result4);  // 输出 false
    }
}
