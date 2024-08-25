package suanfa;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后
 * ，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 */
public class _34ValidPalindrome {
    public static boolean isPalindrome(String s) {
        // 转换字符串为小写并过滤出字母和数字
        String filtered = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        // 初始化左右指针
        int left = 0, right = filtered.length() - 1;

        // 双指针比较
        while (left < right) {
            // 如果左右指针指向的字符不相同，则不是回文串
            if (filtered.charAt(left) != filtered.charAt(right)) {
                return false;
            }
            // 左指针向右移动
            left++;
            // 右指针向左移动
            right--;
        }

        // 如果所有对应位置的字符都相同，则是回文串
        return true;
    }

    // 测试方法
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // 输出: true
        System.out.println(isPalindrome("race a car"));                     // 输出: false
        System.out.println(isPalindrome(" "));                              // 输出: true
    }
}
