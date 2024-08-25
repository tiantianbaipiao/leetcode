package suanfa;

/**
 * 实现一个函数，用来查找一个字符串 (haystack) 中是否包含另一个字符串 (needle)，
 * 如果包含则返回 needle 在 haystack 中第一次出现的位置索引，如果不包含则返回 -1
 */
public class _32StrStr {
    public static int strStr(String haystack, String needle) {
        // 如果 needle 为空字符串，根据题目要求返回 0
        if (needle.isEmpty()) {
            return 0;
        }

        // 使用 Java 内置的方法 indexOf 来查找 needle 在 haystack 中的位置
        return haystack.indexOf(needle);
    }

    // 测试方法
    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));  // 输出: 2
        System.out.println(strStr("aaaaa", "bba")); // 输出: -1
        System.out.println(strStr("", ""));         // 输出: 0
    }
}
