package tips.p_1000.p851_900;

import java.util.Arrays;

/**
 * 给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
 * 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。
 * <p>示例 1：
 * 输入：s = "cba", k = 1
 * 输出："acb"
 * 解释：
 * 在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
 * 在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
 * <p>示例 2：
 * 输入：s = "baaca", k = 3
 * 输出："aaabc"
 * 解释：
 * 在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aacab”。
 * 在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。
 * <p>提示：
 * 1 <= k <= S.length <= 1000
 * s 只由小写字母组成。
 */
public class Demo899 {

    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String ans = s;
            for (int i = 1; i < s.length(); i++) {
                String t = s.substring(i) + s.substring(0, i);
                if (t.compareTo(ans) < 0) {
                    ans = t;
                }
            }
            return ans;
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
