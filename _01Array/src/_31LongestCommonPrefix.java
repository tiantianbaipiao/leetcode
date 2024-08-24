/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""
 */
public class _31LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            // 如果数组为空或长度为0，直接返回空字符串
            return "";
        }

        // 以第一个字符串作为参考
        String first = strs[0];
        // 初始化最长公共前缀为第一个字符串
        String prefix = first;

        // 遍历数组中的每个字符串
        for (int i = 1; i < strs.length; i++) {
            // 更新最长公共前缀
            while (!strs[i].startsWith(prefix)) {
                // 如果当前前缀不是当前字符串的前缀，则逐个字符减少前缀
                prefix = prefix.substring(0, prefix.length() - 1);
                // 如果前缀变为空，则没有公共前缀
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        // 返回最长公共前缀
        return prefix;
    }

    // 测试方法
    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs1));  // 输出: "fl"

        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs2));  // 输出: ""
    }
}
