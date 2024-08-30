/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大
 * 子字符串
 * 。
 */
public class _91LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) return 0;

        // 去除字符串两端的空白字符
        s = s.trim();

        // 从后往前遍历字符串，直到遇到第一个非空格字符
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                // 如果是字母或数字，增加长度
                length++;
            } else {
                // 如果遇到空格，说明已经找到了最后一个单词的边界
                break;
            }
        }

        return length;
    }
}
