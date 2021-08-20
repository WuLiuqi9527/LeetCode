package tips.p_1000.p501_550;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * <p>示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * <p>提示：
 * 1 <= s.length <= 10^4
 * s 仅由小写英文组成
 * 1 <= k <= 10^4
 *
 * @author hc
 */
public class Demo541 {

    static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = s.length();
        for (int l = 0; l < n; l += k << 1) {
            int r = l + k - 1;
            reverse(chars, l, Math.min(r, n - 1));
        }
        return String.valueOf(chars);
    }

    static void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char c = chars[l];
            chars[l] = chars[r];
            chars[r] = c;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcd", 2));
        System.out.println(reverseStr("abcdefg", 2));
    }
}
