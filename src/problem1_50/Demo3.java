package problem1_50;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *  请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 *
 * @author hc
 */
public class Demo3 {

    public int lengthOfLongestSubstring(String s) {

        /**
         * 滑动窗口
         */
        int l = 0, r = -1;
        int[] freq = new int[256];
        int res = 0;

        while (l<s.length()){
            if (r+1 < s.length() && freq[s.charAt(r+1)] == 0){
                freq[s.charAt(++r)]++;
            }else {
                freq[s.charAt(l++)]--;
            }
            res = Math.max(res,r-l+1);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(new Demo3().lengthOfLongestSubstring(new String("bbbbb")));
    }
}
