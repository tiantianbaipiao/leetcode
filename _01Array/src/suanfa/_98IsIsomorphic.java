package suanfa;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 */
public class _98IsIsomorphic {

    /**
     * 判断两个字符串是否是同构的。
     * @param s 第一个字符串
     * @param t 第二个字符串
     * @return 如果是同构的，返回 true；否则返回 false
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // 检查 s 中的字符是否已经被映射到 t 中的字符
            if (mapS.containsKey(charS)) {
                if (mapS.get(charS) != charT) {
                    return false;
                }
            } else {
                mapS.put(charS, charT);
            }

            // 检查 t 中的字符是否已经被映射到 s 中的字符
            if (mapT.containsKey(charT)) {
                if (mapT.get(charT) != charS) {
                    return false;
                }
            } else {
                mapT.put(charT, charS);
            }
        }

        return true;
    }

    // 测试方法
    public static void main(String[] args) {
        _98IsIsomorphic solution = new _98IsIsomorphic();
        String s1 = "egg";
        String t1 = "add";
        boolean result1 = solution.isIsomorphic(s1, t1);
        System.out.println(result1);  // 输出 true

        String s2 = "foo";
        String t2 = "bar";
        boolean result2 = solution.isIsomorphic(s2, t2);
        System.out.println(result2);  // 输出 false

        String s3 = "paper";
        String t3 = "title";
        boolean result3 = solution.isIsomorphic(s3, t3);
        System.out.println(result3);  // 输出 true
    }
}
