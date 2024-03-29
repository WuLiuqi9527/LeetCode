package tips.p_1000.p601_650;

/**
 * 最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
 * Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
 * Paste（粘贴）：粘贴 上一次 复制的字符。
 * 给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。
 * 返回能够打印出 n 个 'A' 的最少操作次数。
 * <p>示例 1：
 * 输入：3
 * 输出：3
 * 解释：
 * 最初, 只有一个字符 'A'。
 * 第 1 步, 使用 Copy All 操作。
 * 第 2 步, 使用 Paste 操作来获得 'AA'。
 * 第 3 步, 使用 Paste 操作来获得 'AAA'。
 * <p>示例 2：
 * 输入：n = 1
 * 输出：0
 * <p>提示：
 * 1 <= n <= 1000
 *
 * @author hc
 */
public class Demo650 {

    public static int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                    dp[i] = Math.min(dp[i], dp[i / j] + j);
                }
            }
        }
        return dp[n];
    }

    public static int minSteps2(int n) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                ans += i;
                n /= i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minSteps(3));
        System.out.println(minSteps(4));
    }
}
