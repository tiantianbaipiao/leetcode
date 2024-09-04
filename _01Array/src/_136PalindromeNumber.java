public class _136PalindromeNumber {

    /**
     * 判断一个整数是否是回文数。
     * 
     * @param x 输入的整数
     * @return 如果x是回文数则返回true，否则返回false
     */
    public boolean isPalindrome(int x) {
        // 负数和以0开头的正数都不是回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            int pop = x % 10;
            x /= 10;

            // 检查溢出情况
            if (reversedHalf > Integer.MAX_VALUE / 10 || (reversedHalf == Integer.MAX_VALUE / 10 && pop > 7)) {
                return false;
            }
            if (reversedHalf < Integer.MIN_VALUE / 10 || (reversedHalf == Integer.MIN_VALUE / 10 && pop < -8)) {
                return false;
            }

            reversedHalf = reversedHalf * 10 + pop;
        }

        // 当数字长度为奇数时，我们可以通过reversedHalf/10来消除中间的数字
        return x == reversedHalf || x == reversedHalf / 10;
    }

    public static void main(String[] args) {
        _136PalindromeNumber solution = new _136PalindromeNumber();
        int x = 121;
        System.out.println(solution.isPalindrome(x)); // 输出应为true

        x = -121;
        System.out.println(solution.isPalindrome(x)); // 输出应为false

        x = 123;
        System.out.println(solution.isPalindrome(x)); // 输出应为false
    }
}
