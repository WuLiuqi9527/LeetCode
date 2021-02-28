package p251_300;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 * <p>
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；
 * 换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * 示例 1：
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 *
 * @author hc
 */
public class Demo279 {

    public int numSquares(int n) {

        if (n < 4) {
            return n;
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 最多可以分解为 i 个1
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j]+1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Demo279().numSquares(12));
    }
}
