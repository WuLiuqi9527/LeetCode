package tips.p_1000.p1_50;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>示例 1：
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * <p>示例 2：
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * <p>示例 3：
 * 输入：s = ""
 * 输出：0
 * <p>提示：
 * 0 <= s.length <= 3 * 10^4
 * s[i] 为 '(' 或 ')'
 *
 * @author hc
 */
public class Demo32 {

    public int longestValidParentheses(String s) {
        return Math.max(calc(s, 0, s.length(), '(', 1),
                calc(s, s.length() - 1, -1, ')', -1));
    }

    private static int calc(String s, int l, int r, char c, int dir) {
        int max = 0, sum = 0, curLen = 0, validLen = 0;
        while (l != r) {
            sum += s.charAt(l) == c ? 1 : -1;
            curLen++;
            if (sum < 0) {
                max = Math.max(max, validLen);
                sum = 0;
                curLen = 0;
                validLen = 0;
            } else if (sum == 0) {
                validLen = curLen;
            }
            l += dir;
        }
        return Math.max(max, validLen);
    }

    public int longestValidParentheses2(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] + 2 : 2);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
