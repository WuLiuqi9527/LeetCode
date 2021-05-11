package tip.lt1000.p101_150;

/**
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * <p>
 * 说明:
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 *
 * @author hc
 */
public class Demo134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int num = 0;

        while (num < len) {
            int sumGas = 0;
            int SumCost = 0;
            // 记录走过站点数目
            int count = 0;
            while (count < len) {
                int j = (num + count) % len;
                sumGas += gas[j];
                SumCost += cost[j];
                if (SumCost > sumGas) {
                    break;
                }
                count++;
            }

            if (count == len) {
                return num;
            } else {
                num = num + count + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Demo134().canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Demo134().canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
        System.out.println(new Demo134().canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1}));
        System.out.println(new Demo134().canCompleteCircuit(new int[]{5, 8, 2, 8}, new int[]{6, 5, 6, 6}));
        System.out.println(new Demo134().canCompleteCircuit(new int[]{3, 1, 1}, new int[]{1, 2, 2}));
    }
}
