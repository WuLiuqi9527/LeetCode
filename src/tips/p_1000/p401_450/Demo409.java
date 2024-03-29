package tips.p_1000.p401_450;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>示例 1:
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * @author hc
 */
public class Demo409 {

    public int longestPalindrome(String s) {

        int res = 0;
        // A ~ z 58个ASCII码
        int[] cnt = new int[58];
        for (char s1 : s.toCharArray()) {
            ++cnt[s1 - 'A'];
        }

        for (int c : cnt) {
            // c - (c & 1) 判定 c 奇偶
            // 偶数直接加, 奇数减 1
            res += c - (c & 1);
        }

        return res < s.length() ? res + 1 : res;
    }
}
