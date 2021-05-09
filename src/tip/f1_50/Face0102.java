package tip.f1_50;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>示例 1：
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * <p>示例 2：
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * <p>说明：
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 * @author hc
 */
public class Face0102 {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] sum = new int[256];
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            ++sum[s1.charAt(i)];
            --sum[s2.charAt(i)];
        }
        for (int s : sum) {
            if (s != 0) {
                return false;
            }
        }
        return true;
    }
}
