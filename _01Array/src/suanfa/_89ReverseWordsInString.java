package suanfa;

/**
 * 力扣第151题是“翻转字符串里的单词”，要求将输入字符串中的单词顺序翻转
 */
public class _89ReverseWordsInString {

    public String reverseWords(String s) {
        // 去除字符串两端的空白字符
        s = s.trim();

        // 使用空格分割字符串，忽略多余的空格
        String[] words = s.split("\\s+");

        // 创建一个新的字符串数组来存储翻转后的单词
        StringBuilder reversed = new StringBuilder();

        // 从最后一个单词开始向前遍历
        for (int i = words.length - 1; i >= 0; i--) {
            // 添加单词，并在每个单词之间添加一个空格
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }

        // 返回翻转后的字符串
        return reversed.toString();
    }
}
