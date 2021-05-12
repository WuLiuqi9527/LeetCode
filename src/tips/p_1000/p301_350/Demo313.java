package tips.p_1000.p301_350;

/**
 * 编写一段程序来查找第 n 个超级丑数。
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 * <p>示例:
 * 输入: n = 12, primes = [2,7,13,19]
 * 输出: 32
 * 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * <p>说明:
 * 1 是任何给定 primes 的超级丑数。
 * 给定 primes 中的数字以升序排列。
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
 * 第 n 个超级丑数确保在 32 位有符整数范围内。
 *
 * @author hc
 */
public class Demo313 {

    public int nthSuperUglyNumber(int n, int[] primes) {

        int len = primes.length;
        int[] res = new int[n];
        res[0] = 1;

        // primes 指针
        int[] index = new int[len];
        for (int i = 1; i < n; i++) {
            int next = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                next = Math.min(next, res[index[j]] * primes[j]);
            }

            // 将所有可以得到这个值的指针右移一位，用来防止相同数字的产生
            for (int j = 0; j < len; j++) {
                if (next == res[index[j]] * primes[j]) {
                    ++index[j];
                }
            }
            res[i] = next;
        }
        return res[n - 1];
    }
}
