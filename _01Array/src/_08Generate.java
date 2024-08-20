import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 */
public class _08Generate {

  // 生成杨辉三角
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < numRows; i++) {
      List<Integer> row = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          row.add(1);
        } else {
          int aboveLeft = result.get(i - 1).get(j - 1);
          int aboveRight = result.get(i - 1).get(j);
          row.add(aboveLeft + aboveRight);
        }
      }
      result.add(row);
    }

    return result;
  }

  public static void main(String[] args) {
    _08Generate solution = new _08Generate();
    int numRows = 5;
    List<List<Integer>> triangle = solution.generate(numRows);
    for (List<Integer> row : triangle) {
      System.out.println(row);
    }
  }
}

