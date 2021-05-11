package tip.lt1000.p301_350;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * @author hc
 */
public class Demo343 {

    public int integerBreak(int n) {
        return breakInteger(n);
    }

    private int breakInteger(int n) {

        if (n == 1) {
            return 1;
        }

        int[] memo = new int[n + 1];
        if (memo[n] != 0) {
            return memo[n];
        }

        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * breakInteger(n - i)));
        }

        memo[n] = res;
        return res;
    }

    public int integerBreak2(int n) {

        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                memo[i] = Math.max(memo[i], Math.max(j * (i - j), j * memo[i - j]));
            }
        }

        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new Demo343().integerBreak(30));
    }
}
