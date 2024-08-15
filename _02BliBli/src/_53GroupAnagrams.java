import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词
 */
public class _53GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) return new ArrayList<>();

    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
      char[] ca = s.toCharArray();
      Arrays.sort(ca);
      String key = new String(ca);
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(s);
    }

    return new ArrayList<>(map.values());
  }
}

