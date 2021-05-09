package tip.p101_150;

import java.util.Arrays;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * 返回符合要求的 最少分割次数 。
 * <p>
 * 示例 1：
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * <p>
 * 示例 2：
 * 输入：s = "a"
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：s = "ab"
 * 输出：1
 *
 * @author hc
 */
public class Demo132 {

    public int minCut(String s) {

        if (s == null || s.length() <= 1) {
            return 0;
        }

        int len = s.length();
        int dp[] = new int[len];
        Arrays.fill(dp, len - 1);

        for (int i = 0; i < len; i++) {
            // 注意偶数长度与奇数长度回文串的特点
            // 奇数回文串以1个字符为中心
            minCutHelper(s, i, i, dp);
            // 偶数回文串以2个字符为中心
            minCutHelper(s, i, i + 1, dp);
        }
        return dp[len - 1];
    }

    private void minCutHelper(String s, int i, int j, int[] dp) {

        int len = s.length();

        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {

            /**
             * 中心扩展
             * 如果以当前字符为中心的最大回文串左侧为 i ，右侧为 j，那 s[i] ~ s[j] 长度是不需要切割的，
             * 只需要在 s[i-1] 处切一刀即可，即 dp[i-1]+1 。
             * 所以更新 dp[j] = min(dp[j] , dp[i-1]+1)，不断往外扩散更新 dp 值即可
             */
            dp[j] = Math.min(dp[j], i == 0 ? 0 : dp[i - 1] + 1);
            i--;
            j++;
        }
    }
}
