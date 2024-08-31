package suanfa;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）
 * 字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
public class _94IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        // 如果 s 为空，直接返回 true
        if (s.isEmpty()) return true;

        int sIndex = 0; // s 的索引
        int tIndex = 0; // t 的索引

        // 遍历 t 字符串
        while (tIndex < t.length()) {
            // 如果当前字符相等，s 的索引加 1
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                // 如果 s 的索引达到 s 的长度，说明 s 已经完全匹配
                if (sIndex == s.length()) {
                    return true;
                }
            }
            // t 的索引加 1
            tIndex++;
        }

        // 如果没有完全匹配，返回 false
        return false;
    }
}
