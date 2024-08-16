import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
 * 如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 */
public class _69WordBreak {
  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> dict = new HashSet<>(wordDict);
    int len = s.length();
    boolean[] dp = new boolean[len + 1];
    dp[0] = true; // 空字符串可以被覆盖

    for (int i = 1; i <= len; i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && dict.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }

    return dp[len];
  }
}

