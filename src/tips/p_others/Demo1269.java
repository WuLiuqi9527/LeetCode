package tips.p_others;

/**
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 * <p>示例 1：
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 * <p>示例 2：
 * 输入：steps = 2, arrLen = 4
 * 输出：2
 * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 * 向右，向左
 * 不动，不动
 * <p>示例 3：
 * 输入：steps = 4, arrLen = 2
 * 输出：8
 * <p>提示：
 * 1 <= steps <= 500
 * 1 <= arrLen <= 10^6
 *
 * @author hc
 */
public class Demo1269 {

    public int numWays(int steps, int arrLen) {
        int mod = 1000000007;
        // 当步数不大但是数组长度很长时，数组靠后大部分位置没有必要去遍历
        // 因为步长为 steps，所以理论上指针可以到达的极限位置也就是 steps/2+1
        int max = Math.min(steps / 2 + 1, arrLen - 1);
        int[][] dp = new int[steps + 1][max + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= max; j++) {
                if (j == 0) {
                    //位于最左边时，只能从上一步的当前位置或是右边一位转移过来
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j + 1]) % mod;
                } else if (j == max) {
                    //位于最右边时，只能从上一步的当前位置或是左边一位转移过来
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % mod;
                } else {
                    // 三者直接累加可能存在 int 类型数值溢出问题
                    dp[i][j] = ((dp[i - 1][j - 1] + dp[i - 1][j]) % mod
                            + dp[i - 1][j + 1]) % mod;
                }
            }
        }
        return dp[steps][0];
    }

    public int numWays2(int steps, int arrLen) {
        // 二维空间降低到一维
        int mod = 1000000007;
        int max = Math.min(steps / 2 + 1, arrLen - 1);
        int[] dp = new int[max + 1];
        dp[0] = 1;
        for (int i = 1; i <= steps; i++) {
            int[] tem = new int[max + 1];
            for (int j = 0; j <= max; j++) {
                if (j == 0) {
                    tem[j] = (dp[j] + dp[j + 1]) % mod;
                } else if (j == max) {
                    tem[j] = (dp[j] + dp[j - 1]) % mod;
                } else {
                    tem[j] = ((dp[j] + dp[j - 1]) % mod + dp[j + 1]) % mod;
                }
            }
            dp = tem;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new Demo1269().numWays2(27, 7));
    }
}
