package suanfa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 如：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */

public class _35LetterCombinations {
  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits == null || digits.isEmpty()) return result;

    Map<Character, String> map = new HashMap<>();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");

    // 使用迭代代替递归
    List<String> currentCombinations = new ArrayList<>();
    currentCombinations.add("");

    for (char digit : digits.toCharArray()) {
      List<String> nextCombinations = new ArrayList<>();
      String letters = map.get(digit);
      for (String combination : currentCombinations) {
        for (char letter : letters.toCharArray()) {
          nextCombinations.add(combination + letter);
        }
      }
      currentCombinations = nextCombinations;
    }

    result = currentCombinations;
    return result;
  }

  // 测试代码
  public static void main(String[] args) {
    _35LetterCombinations combinations = new _35LetterCombinations();
    String digits = "23";
    List<String> result = combinations.letterCombinations(digits);
    System.out.println("Letter Combinations: " + result);
  }
}

