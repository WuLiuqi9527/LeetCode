package tips.o_68.o1_50;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成 [整数长度] 的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * <p>示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * <p>提示：
 * 2 <= n <= 58
 *
 * @author hc
 */
public class Offer14One {

    int[] memo;

    public int cuttingRope(int n) {
        memo = new int[n + 1];
        return breakRope(n);
    }

    private int breakRope(int n) {
        if (n == 1) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }

        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * breakRope(n - i)));
        }

        memo[n] = res;
        return res;
    }

    public int cuttingRope2(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                memo[i] = Math.max(memo[i], Math.max(j * (i - j), j * memo[i - j]));
            }
        }

        return memo[n];
    }
}
