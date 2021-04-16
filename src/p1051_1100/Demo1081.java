package p1051_1100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。
 * 注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同
 * <p>示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 * <p>示例 2：
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * <p>提示：
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 *
 * @author hc
 */
public class Demo1081 {

    public String smallestSubsequence(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder stack = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (!seen.contains(ch)) {
                while (stack.length() != 0 && stack.charAt(stack.length() - 1) > ch && map.get(stack.charAt(stack.length() - 1)) > 0) {
                    char tem = stack.charAt(stack.length() - 1);
                    stack.setLength(stack.length() - 1);
                    seen.remove(tem);
                }
                seen.add(ch);
                stack.append(ch);
            }
            map.put(ch, map.get(ch) - 1);
        }
        return stack.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Demo1081().smallestSubsequence("bcabc"));
        System.out.println(new Demo1081().smallestSubsequence("cbacdcbc"));
    }
}
