package tip.lt1000.p1_50;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 示例 1：
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 *
 * @author hc
 */
public class Demo10 {

    public boolean isMatch(String s, String p) {
        // 从后往前匹配
        return recur(s.toCharArray(), p.toCharArray(), s.length() - 1, p.length() - 1);
    }

    public boolean recur(char[] s, char[] p, int sIndex, int pIndex) {

        if (pIndex < 0) {
            return sIndex == pIndex;
        }

        if (sIndex < 0) {
            while (pIndex >= 0 && p[pIndex] == '*') {
                pIndex -= 2;
            }
            return pIndex == sIndex;
        }

        if (p[pIndex] != '*') {
            // . or 字母
            if (p[pIndex] == '.') {
                // *, * 可以匹配任意字符, 直接递归
                return recur(s, p, sIndex - 1, pIndex - 1);
            } else {
                if (p[pIndex] == s[sIndex]) {
                    // s 和 p 的末尾字母, 若相同，递归
                    return recur(s, p, sIndex - 1, pIndex - 1);
                } else {
                    // s 和 p 的末尾字母, 不相同直接返回 false
                    return false;
                }
            }
        } else {
            // * 可以匹配 0个 or 多个 前一字符
            // * 匹配 0个 表示 0 个前一字符 所以减少两个位置
            if (recur(s, p, sIndex, pIndex - 2)) {
                return true;
            }
            // * 匹配多个
            char cTemp = p[pIndex - 1];
            int sIndexMove = sIndex;
            // 用 p 的末尾去匹配 s 的末尾的1个,2个,3个,4个...直到 * 把 s[0] 都匹配掉
            while (sIndexMove >= 0 && (cTemp == '.' || cTemp == s[sIndexMove])) {
                // * 匹配 1个,2个,3个,4个...
                if (recur(s, p, sIndexMove - 1, pIndex - 2)) {
                    return true;
                }
                sIndexMove--;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Demo10().isMatch("aa", "a"));
        System.out.println(new Demo10().isMatch("aa", "a*"));
        System.out.println(new Demo10().isMatch("ab", ".*"));
        System.out.println(new Demo10().isMatch("aab", "c*a*b"));
        System.out.println(new Demo10().isMatch("mississippi", "mis*is*p*."));
    }
}
