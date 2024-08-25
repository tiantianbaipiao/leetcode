package suanfa;

/**
 * 编写一个函数来生成外观数列的第 n 项。
 * 外观数列的规则是从 1 开始，之后每一项都是对前一项的描述。
 */
public class _39CountAndSay {
  public String countAndSay(int n) {
    if (n == 1) {
      return "1"; // 如果 n 为 1，直接返回 "1"
    }

    String prev = countAndSay(n - 1); // 递归调用，获取前一项
    StringBuilder sb = new StringBuilder(); // 使用 StringBuilder 来构建新的序列

    int count = 1; // 初始化计数器
    for (int i = 1; i < prev.length(); i++) {
      if (prev.charAt(i) == prev.charAt(i - 1)) { // 如果当前字符与前一个字符相同
        count++; // 计数器加一
      } else {
        sb.append(count).append(prev.charAt(i - 1)); // 描述前一个字符及其出现次数
        count = 1; // 重置计数器
      }
    }

    // 处理最后一个字符
    sb.append(count).append(prev.charAt(prev.length() - 1));

    return sb.toString(); // 返回构建好的字符串
  }

  public static void main(String[] args) {
    System.out.println(new _39CountAndSay().countAndSay(4));
  }
}
