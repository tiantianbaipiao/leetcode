package suanfa;

/**
 * 计算质数的个数
 */
public class _01CountPrimes {
  // 1.暴力解法
  public int countPrimes_01(int n) {
    int count = 0;
    if ( n == 0 || n == 1 ) {
      return 0;
    }
    for ( int i = 2; i < n; i++){
      if(isPrimes(i)){
        count++;
      }
    }
    return count;
  }

  private boolean isPrimes(int i) {
    for (int j = 2; j < i; j++){
      if(i % j == 0){
        return false;
      }
    }
    return true;
  }

  // 埃式筛选(标记法)
  public int countPrimes_02(int n) {
    // 1. 定义一个布尔类型数组用于标记数字是否为质数
    boolean[] isPrimes = new boolean[n]; // 默认为false 表示质数
    // 2. 定义计数器
    int count = 0;
    // 3.判断特殊情况
    if ( n == 0 || n == 1 ) {
      return 0;
    }
    // 4.遍历
    for ( int i = 2; i < n; i++){
      if(!isPrimes[i]){
        count++;
        for ( int j = i; j < n; j += i){
          isPrimes[j] = true;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    _01CountPrimes countPrimes = new _01CountPrimes();
    System.out.println(countPrimes.countPrimes_01(10));
    System.out.println(countPrimes.countPrimes_02(10));
  }
}
