import java.util.HashMap;
import java.util.Map;

public class _97RansomNote {

    /**
     * 判断 ransomNote 是否可以由 magazine 中的字符组成。
     * @param ransomNote 赎金信字符串
     * @param magazine 杂志字符串
     * @return 如果可以组成，返回 true；否则返回 false
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        // 统计杂志中每个字符的出现次数
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
        }

        // 检查赎金信中的每个字符是否可以在杂志中找到
        for (char c : ransomNote.toCharArray()) {
            if (!magazineMap.containsKey(c) || magazineMap.get(c) == 0) {
                return false;
            }
            magazineMap.put(c, magazineMap.get(c) - 1);
        }

        return true;
    }

    // 测试方法
    public static void main(String[] args) {
        _97RansomNote solution = new _97RansomNote();
        String ransomNote = "aa";
        String magazine = "aab";
        boolean result = solution.canConstruct(ransomNote, magazine);
        System.out.println(result);  // 输出 true
    }
}
