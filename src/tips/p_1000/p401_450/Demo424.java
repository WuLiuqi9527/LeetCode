package tips.p_1000.p401_450;

/**
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。
 * 在执行上述操作后，找到包含重复字母的最长子串的长度。
 * 注意：字符串长度 和 k 不会超过 104。
 * <p>
 * 示例 1：
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * <p>
 * 示例 2：
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 *
 * @author hc
 */
public class Demo424 {

    /**
     * K == 0, 求字符串中最长连续字串 滑窗更新最大值
     * K > 0, 允许变换字符串的 K 个字符，使之变成一个连续串
     * 关键点：如何判断一个字符串改变 K 个字符，能够变成一个连续串
     * -> 当前字符串中的出现次数最多的字母个数 + K > 串长度，那么这个串就是满足条件的
     */
    public int characterReplacement(String s, int k) {

        if (s == null) {
            return 0;
        }

        // 双指针 滑窗
        int[] abc = new int[26];
        int len = s.length();
        // 滑动窗口内相同字母出现次数的 历史 最大值
        int max = 0;
        int left = 0, right = 0;
        // [left, right)
        while (right < len) {
            int ch = s.charAt(right) - 'A';
            ++abc[ch];
            max = Math.max(max, abc[ch]);
            // k 不够用
            if (max + k < right - left + 1) {
                --abc[s.charAt(left) - 'A'];
                ++left;
            }
            ++right;
        }
        return right - left;
    }

    public static void main(String[] args) {
        System.out.println(new Demo424().characterReplacement("ABAB", 2));
        System.out.println(new Demo424().characterReplacement("AABABBA", 1));
    }
}
