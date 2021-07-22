package tips.p_1000.p101_150;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设 【字典中没有重复的单词】。
 * <p>示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *
 * @author hc
 */
public class Demo139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] 表示字符串 s 前 i 个字符组成的字符串 s[0..i-1] 是否能被空格拆分
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        // dp[i] 表示字符串 s 前 i 个字符组成的字符串 s[0..i-1] 是否能被空格拆分
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        // 每次并不需要从s[0]开始搜索。
        // 因为 wordDict 中的字符串长度是有限的。只需要从 i-maxw 开始搜索就可以了
        int maxw = 0;
        Set<String> set = new HashSet();
        for (String str : wordDict) {
            set.add(str);
            maxw = Math.max(maxw, str.length());
        }

        for (int i = 1; i <= len; i++) {
            for (int j = Math.max(i - maxw, 0); j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public boolean wordBreak3(String s, List<String> wordDict) {
        // dp[i] 表示字符串 s 前 i 个字符组成的字符串 s[0..i-1] 是否能被空格拆分
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        // 每次并不需要从s[0]开始搜索。
        // 因为 wordDict 中的字符串长度是有限的。只需要从 i-maxw 开始搜索就可以了
        int maxw = 0;
        Set<String> set = new HashSet();
        for (String str : wordDict) {
            set.add(str);
            maxw = Math.max(maxw, str.length());
        }

        for (int i = 1; i <= len; i++) {
            for (int j = i; j >= 0 && j >= i - maxw; j--) {
                // 倒着遍历 变快了
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
