package p401_450;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 *
 * 示例 1:
 * 输入: s: "cbaebabacd" p: "abc"
 * 输出: [0, 6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *
 * 示例 2:
 * 输入: s: "abab" p: "ab"
 * 输出: [0, 1, 2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 * @author hc
 */
public class Demo438 {


    public List<Integer> findAnagrams(String s, String p) {

        /**
         * 滑动窗口
         * 不考虑顺序 计算 小写字母 出现的频率即可
         */
        if (s.length() < p.length()){return new ArrayList<>();}

        int l =0, r = -1;
        int[] freqS = new int[26];
        int[] freqP = new int[26];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            freqP[p.charAt(i) - 'a']++;
            freqS[s.charAt(++r) - 'a']++;
        }
        if (Arrays.equals(freqS,freqP)){
            res.add(l);
        }

        while (r+1 < s.length()){
            freqS[s.charAt(++r)-'a']++;
            freqS[s.charAt(l++)-'a']--;

            if (Arrays.equals(freqS,freqP)){
                res.add(l);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo438().findAnagrams(new String("abab"), new String("ab")));
    }
}
