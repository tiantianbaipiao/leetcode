package suanfa;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 */
public class _87FindAnagrams {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    if (s == null || p == null || s.length() < p.length()) {
      return result;
    }

    int[] patternCount = new int[26];  // 存储 p 中每个字符的出现次数
    int[] windowCount = new int[26];   // 存储滑动窗口中每个字符的出现次数

    // 初始化 p 中每个字符的出现次数
    for (char c : p.toCharArray()) {
      patternCount[c - 'a']++;
    }

    int left = 0;  // 窗口左边界
    int right = 0; // 窗口右边界
    int valid = 0; // 当前窗口内字符与 p 匹配的数量

    while (right < s.length()) {
      char c = s.charAt(right);
      right++;

      // 更新窗口内的字符计数
      if (patternCount[c - 'a'] > 0) {
        windowCount[c - 'a']++;
        if (windowCount[c - 'a'] == patternCount[c - 'a']) {
          valid++;
        }
      }

      // 当窗口大小超过 p 的长度时，缩小窗口
      while (right - left >= p.length()) {
        // 检查窗口内的字符是否与 p 形成字母异位词
        if (valid == patternCount.length) {
          result.add(left);
        }

        char d = s.charAt(left);
        left++;

        // 更新窗口内的字符计数
        if (patternCount[d - 'a'] > 0) {
          if (windowCount[d - 'a'] == patternCount[d - 'a']) {
            valid--;
          }
          windowCount[d - 'a']--;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    _87FindAnagrams solution = new _87FindAnagrams();
    String s = "cbaebabacd";  // 修改为实际的输入
    String p = "abc";
    List<Integer> result = solution.findAnagrams(s, p);
    System.out.println(result);  // 输出: [0, 6]
  }
}


