package suanfa;

/**
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列
 * 输入：s = "abc"
 * 输出：3
 */
public class _37CountSubstrings {
  public int countSubstrings(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }

    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      // 以单个字符为中心扩展
      count += expandAroundCenter(s, i, i);

      // 如果不是最后一个字符，则以两个相邻字符为中心扩展
      if (i < s.length() - 1) {
        count += expandAroundCenter(s, i, i + 1);
      }
    }

    return count;
  }

  private int expandAroundCenter(String s, int left, int right) {
    int count = 0;
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      count++;
      left--;
      right++;
    }
    return count;
  }

  public static void main(String[] args) {
    _37CountSubstrings counter = new _37CountSubstrings();
    String s = "abc";
    System.out.println(counter.countSubstrings(s)); // 输出：3
  }
}

