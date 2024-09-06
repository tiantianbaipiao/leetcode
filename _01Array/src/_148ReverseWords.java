/**
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class _148ReverseWords {
    public String reverseWords(String s) {
        // 去除字符串两端的空白字符
        s = s.trim();

        // 使用空格分割字符串
        String[] words = s.split("\\s+");

        // 构建新的字符串
        StringBuilder reversedString = new StringBuilder();

        for (String word : words) {
            // 反转每个单词
            String reversedWord = new StringBuilder(word).reverse().toString();

            // 添加反转后的单词和空格
            reversedString.append(reversedWord).append(" ");
        }

        // 去除末尾多余的空格并返回结果
        return reversedString.toString().trim();
    }

    public static void main(String[] args) {
        _148ReverseWords solution = new _148ReverseWords();
        String s = "Let's take LeetCode contest";

        String reversedWords = solution.reverseWords(s);
        System.out.println(reversedWords); // 输出 "s'teL ekat edoCteeL tsetnoc"
    }
}
