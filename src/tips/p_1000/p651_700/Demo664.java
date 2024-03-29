package tips.p_1000.p651_700;

import java.util.Arrays;

/**
 * 有台奇怪的打印机有以下两个特殊要求：
 * 打印机每次只能打印由 同一个字符 组成的序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
 * <p>示例 1：
 * 输入：s = "aaabbb"
 * 输出：2
 * 解释：首先打印 "aaa" 然后打印 "bbb"。
 * <p>示例 2：
 * 输入：s = "aba"
 * 输出：2
 * 解释：首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
 * <p>提示：
 * 1 <= s.length <= 100
 * s 由小写英文字母组成
 *
 * @author hc
 */
public class Demo664 {

    public int strangePrinter(String s) {

        int len = s.length();
        // 字符串在区间 [i, j] 中需要最少的打印次数
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = 101;
            }
        }

        for (int i = len - 1; i >= 0; --i) {
            // 打印一个字符串 dp[i][i] 只需打印一次
            dp[i][i] = 1;
            for (int j = i + 1; j < len; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    for (int k = i; k < j; ++k) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][len - 1];
    }
}
