package tips.o_68.o1_50;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且 m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。
 * 请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是 8 时，我们把它剪成长度分别为 2、3、3的三段，此时得到的最大乘积是18。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * <p>示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * <p>提示：
 * 2 <= n <= 1000
 *
 * @author hc
 */
public class Offer14Two {

    /**
     * 2 <= n <= 1000 大数越界情况下的求余问题
     * 按取绳子I算法 可以 import java.math.BigInteger 代替普通 int
     */
    public int cuttingRope(int n) {
        return n <= 3 ? n - 1 : (int) process(n);
    }

    public long process(long n) {
        return n > 4 ? (process(n - 3) * 3) % 1000000007 : n;
    }
}
