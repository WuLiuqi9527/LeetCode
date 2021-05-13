package tips.o_68.o1_50;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>示例 1：
 * 输入：n = 2
 * 输出：2
 * <p>示例 2：
 * 输入：n = 7
 * 输出：21
 * <p>示例 3：
 * 输入：n = 0
 * 输出：1
 * 提示：
 * 0 <= n <= 100
 *
 * @author hc
 */
public class Offer10Two {

    public int numWays(int n) {
        if (n == 1 || n == 0) {return 1;}
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }

        return dp[n];
    }

    public int numWays2(int n) {
        if (n == 1 || n == 0) {return 1;}
        int[] dp = new int[2];
        dp[0] = 1; dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int tem = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = tem % 1000000007;
        }

        return dp[1];
    }
}
