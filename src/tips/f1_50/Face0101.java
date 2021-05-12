package tips.f1_50;

import java.util.HashSet;

/**
 * * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>示例 1：
 * 输入: s = "leetcode"
 * 输出: false
 * <p>示例 2：
 * 输入: s = "abc"
 * 输出: true
 * <p>限制：
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 *
 * @author hc
 */
public class Face0101 {

    public static boolean isUnique(String astr) {
        return astr.chars().distinct().count() == astr.length();
    }

    /**
     * 利用 Set 的不可重复性
     */
    public boolean isUnique2(String astr) {
        HashSet<Character> set = new HashSet<>();
        for (char c : astr.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 用数组标识位置
     */
    public boolean isUnique3(String astr) {
        int[] hash = new int[26];
        for (char ch : astr.toCharArray()) {
            hash[ch - 'a']++;
            if (hash[ch - 'a'] > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 位运算，用一个 int 来标识位置
     */
    public boolean isUnique4(String astr) {
        int mark = 0;
        for (char ch : astr.toCharArray()) {
            int index = ch - 'a';
            if ((mark & (1 << index)) != 0) {
                return false;
            } else {
                mark |= (1 << index);
            }
        }
        return true;
    }
}
