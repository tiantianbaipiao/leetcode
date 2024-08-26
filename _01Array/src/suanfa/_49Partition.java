package suanfa;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是
 * 回文串
 *  。返回 s 所有可能的分割方案。
 */
public class _49Partition {
  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    backtrack(s, 0, new ArrayList<>(), result);
    return result;
  }

  private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
    if (start == s.length()) {
      // 如果到达字符串末尾，将当前组合添加到结果中
      result.add(new ArrayList<>(current));
      return;
    }

    for (int i = start; i < s.length(); i++) {
      String sub = s.substring(start, i + 1);
      if (isPalindrome(sub)) {
        // 如果子串是回文串，则加入当前组合
        current.add(sub);
        // 递归分割剩余部分
        backtrack(s, i + 1, current, result);
        // 回溯，移除最后一个添加的子串
        current.remove(current.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String str) {
    int left = 0;
    int right = str.length() - 1;

    while (left < right) {
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }

    return true;
  }
}

