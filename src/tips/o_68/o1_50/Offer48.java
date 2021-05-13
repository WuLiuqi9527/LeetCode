package tips.o_68.o1_50;

import java.util.Arrays;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>提示：
 * s.length <= 40000
 *
 * @author hc
 */
public class Offer48 {

    public int lengthOfLongestSubstring(String s) {

        int res = 0;
        int l = 0, r = -1;
        int[] freq = new int[256];

        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(++r)]++;
            } else {
                freq[s.charAt(l++)]--;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {

        if (s == null || s.equals("")) {
            return 0;
        }

        int res = 0;
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int pre = -1;

        for (int i = 0; i < s.length(); i++) {
            // pre: i-1 位置 字符的前一个字符下标
            // map[s.charAt(i): 当前字符的前一个字符下标
            pre = Math.max(pre, map[s.charAt(i)]);

            // 更新 rea 维护 map
            res = Math.max(res, i - pre);
            map[s.charAt(i)] = i;
        }
        return res;
    }
}
