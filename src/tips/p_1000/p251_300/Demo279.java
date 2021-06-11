package tips.p_1000.p251_300;

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

    public int numSquares2(int n) {
        /**
         * 四平方数定理：
         *      任何一个正整数都可以表示成不超过四个整数的平方之和。 推论：满足四数平方和定理的数n（四个整数的情况），必定满足 n=4^a(8b+7)
         * 任何正整数都可以拆分成不超过4个数的平方和 ---> 答案只可能是 1,2,3,4
         * 如果一个数可以被拆成4个数的平方和，则这个数还满足 n = 4^a(8b+7) ---> 因此可以先看这个数是否满足上述公式，如果不满足，答案就是 1,2,3了
         * 如果这个数本来就是某个数的平方，那么答案就是 1，否则答案就只剩 2,3了
         * 如果答案是 2，即 n=a^2+b^2，那么我们可以枚举 a，来验证，如果验证通过则答案是 2
         * 只能是 3
         */
        while(n % 4 == 0) {
            n /= 4;
        }
        //判 4
        if(n % 8 == 7) {
            return 4;
        }

        //判 1
        for(int i = 0; i * i <= n; ++i) {
            if(n - i * i == 0) {
                return 1;
            }
        }

        //判 2
        for(int i = 0; i * i < n; ++i) {
            for(int j = 0; j * j < n; ++j) {
                if(n - i * i - j * j == 0) {
                    return 2;
                }
            }
        }

        // 4、1、2，都不是，直接返回3
        return 3;
    }

    public static void main(String[] args) {
        System.out.println(new Demo279().numSquares(12));
    }
}
