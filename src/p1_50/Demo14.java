package p1_50;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * @author hc
 */
public class Demo14 {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String s = strs[0];
        for (String str : strs) {
            while (!str.startsWith(s)) {
                if (s.length() == 0) {
                    return "";
                }
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Demo14().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(new Demo14().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
