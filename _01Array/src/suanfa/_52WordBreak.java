package suanfa;

import java.util.*;

/**
 * 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，
 * 使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
 */
public class _52WordBreak {
  public List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> dictSet = new HashSet<>(wordDict);
    Map<Integer, List<String>> memo = new HashMap<>();
    return dfs(s, 0, dictSet, memo);
  }

  private List<String> dfs(String s, int start, Set<String> dictSet, Map<Integer, List<String>> memo) {
    if (memo.containsKey(start)) {
      return memo.get(start);
    }

    List<String> res = new ArrayList<>();
    if (start == s.length()) {
      res.add("");
      return res;
    }

    for (int end = start + 1; end <= s.length(); end++) {
      String sub = s.substring(start, end);
      if (dictSet.contains(sub)) {
        List<String> subRes = dfs(s, end, dictSet, memo);
        for (String subStr : subRes) {
          res.add(sub + (subStr.isEmpty() ? "" : " ") + subStr);
        }
      }
    }

    memo.put(start, res);
    return res;
  }
}
