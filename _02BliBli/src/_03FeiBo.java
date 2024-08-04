/**
 * 斐波那契数列
 * */
public class _03FeiBo {
  public int feiBo(int n){
    if(n == 0){
      return 0;
    }
    if(n == 1){
      return 1;
    }
    if(n > 1){
      return feiBo(n - 1) + feiBo(n - 2);
    }
    return 0;
  }
  public int feiBo2(int n){
    if(n < 0){
      throw new IllegalArgumentException("n cannot be negative");
    }
    if(n == 0){
      return 0;
    }
    if(n == 1){
      return 1;
    }
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for(int i = 2; i <= n; i++){
      dp[i] = dp[i - 1] + dp[i - 2];
      dp[i] %= 1000000007;
    }
    return dp[n];
  }

  public static void main(String[] args) {
    _03FeiBo feiBo = new _03FeiBo();
    System.out.println(feiBo.feiBo(45));
    System.out.println(feiBo.feiBo2(45));
  }
}
