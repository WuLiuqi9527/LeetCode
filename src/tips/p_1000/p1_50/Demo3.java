package tips.p_1000.p1_50;

import java.util.Arrays;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 *
 * @author hc
 */
public class Demo3 {

    /**
     * 滑动窗口
     */
    public int lengthOfLongestSubstring(String s) {

        int res = 0, len = s.length();
        int l = 0, r = -1;
        int[] freq = new int[256];

        while (l < len) {
            if (r + 1 < len && freq[s.charAt(r + 1)] == 0) {
                // 窗口内不重复 纳入窗口
                freq[s.charAt(++r)]++;
            } else {
                // 有重复元素进入窗口，移出左边元素,直到重复元素被移出窗口
                freq[s.charAt(l++)]--;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    /**
     * 以 i = ‘a’ 为例，考虑两种情况
     * (1) 上次 'a' 字符出现的位置 map<字符，位置下标> 用数组实现更快 内存上连续
     * (2) 前一个位置 i-1 往前推动到了多远
     */
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

            // 更新 res 维护 map
            res = Math.max(res, i - pre);
            map[s.charAt(i)] = i;
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(new Demo3().lengthOfLongestSubstring2(new String("bbbbb")));
    }
}
