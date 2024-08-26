/**
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1
 * 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，
 * 则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 */
public class _50CanCompleteCircuit {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    if (gas == null || cost == null || gas.length != cost.length) {
      return -1;
    }

    int totalGas = 0;
    int totalCost = 0;
    int start = 0;
    int tank = 0;

    for (int i = 0; i < gas.length; i++) {
      totalGas += gas[i]; // 计算总汽油量
      totalCost += cost[i]; // 计算总花费
      tank += gas[i] - cost[i]; // 当前油箱剩余量

      // 如果油箱剩余量小于 0，则从下一个加油站重新开始
      if (tank < 0) {
        start = i + 1;
        tank = 0;
      }
    }

    // 如果总汽油量大于等于总花费，则可以完成一圈
    if (totalGas < totalCost) {
      return -1;
    }

    return start;
  }
}

