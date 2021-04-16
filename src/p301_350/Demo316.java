package p301_350;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 * <p>示例 2：
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * <p>提示：
 * 1 <= s.length <= 10^4
 * s 由小写英文字母组成
 *
 * @author hc
 */
public class Demo316 {

    public String removeDuplicateLetters(String s) {
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
        System.out.println(new Demo316().removeDuplicateLetters("bcabc"));
        System.out.println(new Demo316().removeDuplicateLetters("cbacdcbc"));
    }
}
