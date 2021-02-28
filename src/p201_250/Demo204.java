package p201_250;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * <p>
 * 提示：
 * 0 <= n <= 5 * 106
 *
 * @author hc
 */
public class Demo204 {

    public int countPrimes(int n) {

        if (n <= 1) {
            return 0;
        }

        int count = 0;
        boolean[] flag = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!flag[i]) {
                count++;

                // i 的整数倍全部划去
                for (int j = i + i; j < n; j += i) {
                    flag[j] = true;
                }
            }
        }
        return count;
    }
}
