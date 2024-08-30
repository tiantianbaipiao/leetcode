import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 */
public class _93TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int start = 0;
        int end = 0;
        int currentWidth = 0;

        while (start < words.length) {
            // 找到当前行的结束位置
            end = start;
            currentWidth = words[start].length();
            while (end + 1 < words.length && currentWidth + 1 + words[end + 1].length() <= maxWidth) {
                currentWidth += 1 + words[end + 1].length();
                end++;
            }

            // 处理最后一行
            if (end == words.length - 1) {
                result.add(buildLastLine(words, start, end, maxWidth));
                break;
            }

            // 构建当前行
            result.add(buildLine(words, start, end, currentWidth, maxWidth));

            // 移动起始位置
            start = end + 1;
        }

        return result;
    }

    private String buildLine(String[] words, int start, int end, int currentWidth, int maxWidth) {
        int spaces = maxWidth - currentWidth;
        int gaps = end - start;

        // 如果只有一词，左对齐
        if (gaps == 0) {
            return words[start] + padSpaces(spaces);
        }

        // 计算每对单词之间的空格数量
        int evenSpaces = spaces / gaps;
        int extraSpaces = spaces % gaps;

        StringBuilder line = new StringBuilder();

        // 添加单词和空格
        for (int i = start; i < end; i++) {
            line.append(words[i]);
            line.append(padSpaces(evenSpaces + (i - start < extraSpaces ? 1 : 0)));
        }

        line.append(words[end]);

        return line.toString();
    }

    private String buildLastLine(String[] words, int start, int end, int maxWidth) {
        StringBuilder line = new StringBuilder();

        // 添加单词和单个空格
        for (int i = start; i <= end; i++) {
            line.append(words[i]);
            if (i < end) {
                line.append(" ");
            }
        }

        // 填充剩余的空格
        line.append(padSpaces(maxWidth - line.length()));

        return line.toString();
    }

    private String padSpaces(int count) {
        // 使用 StringBuilder 生成指定数量的空格
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < count; i++) {
            spaces.append(" ");
        }
        return spaces.toString();
    }
}
