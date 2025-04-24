import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 */
public class _18Generate {
  public static List<List<Integer>> generate(int numRows) {
    // 创建结果二维列表保存最后的结果
    List<List<Integer>> res = new ArrayList<>();

    for (int i = 0; i < numRows; i++){
      //每次循环都创建一行row
      List<Integer> row = new ArrayList<>();
      // 首尾都等于1且中间元素等于上一行相邻元素的和
      for (int j = 0; j <= i; j++){ // 第 i 行，总共有 i + 1 个元素！ j就是代码这些元素的下标
        // 首尾为1
        if(j == 0 || j == i){
          row.add(1);
        }else {
          int val = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
          row.add(val);
        }
      }
      res.add(row);
    }
    return res;
  }

  public static void main(String[] args) {
    int numRows = 5;
    List<List<Integer>> triangle = generate(numRows);

    // 打印输出
    for (List<Integer> row : triangle) {
      for (Integer num : row) {
        System.out.print(num + " ");
      }
      System.out.println(); // 换行
    }
  }
}
