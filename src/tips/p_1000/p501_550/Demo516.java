package tips.p_1000.p501_550;

/**
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * <p>示例 1：
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 * <p>示例 2：
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 * <p>提示：
 * 1 <= s.length <= 1000
 * s 仅由小写英文字母组成
 *
 * @author hc
 */
public class Demo516 {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // dp[i][j]表示 s[i..j]代表的字符串的最长回文子序列
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Demo516().longestPalindromeSubseq("bbbab"));
        System.out.println(new Demo516().longestPalindromeSubseq("cbbd"));
    }
}
