package suanfa;// (1)给定一个经过编码的字符串，返回它解码后的字符串。
// (2)编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
// (3)你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
// (4)此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
import java.util.Stack;

public class _13DecodeString {

  /**
   * 解码字符串
   * @param s 编码后的字符串
   * @return 解码后的字符串
   */
  public String decodeString(String s) {
    Stack<Integer> countStack = new Stack<>();
    Stack<StringBuilder> resultStack = new Stack<>();
    StringBuilder current = new StringBuilder();
    int count = 0;

    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        count = count * 10 + (c - '0');
      } else if (c == '[') {
        countStack.push(count);
        resultStack.push(current);
        current = new StringBuilder();
        count = 0;
      } else if (c == ']') {
        StringBuilder temp = current;
        current = resultStack.pop();
        for (int n = countStack.pop(); n > 0; n--) {
          current.append(temp);
        }
      } else {
        current.append(c);
      }
    }

    return current.toString();
  }

  public static void main(String[] args) {
    _13DecodeString decoder = new _13DecodeString();
    String encodedStr = "3[a]2[bc]";
    System.out.println(decoder.decodeString(encodedStr));  // 输出: aaabcbc
  }
}

