package tip.p_contest;

/**
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 * 如果 s 最多包含 一个由连续的 '1' 组成的字段 ，返回 true。否则，返回 false 。
 *
 * 示例 1：
 * 输入：s = "1001"
 * 输出：false
 * 解释：字符串中的 1 没有形成一个连续字段。
 *
 * @author hc
 */
public class Demo5697 {

    public boolean checkOnesSegment(String s) {

        if (s.length() == 1) {
            return true;
        }

        int num = Integer.MAX_VALUE;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                num = i;
            }
            if (s.charAt(i) == '1' && i > num) {
                return false;
            }
        }
        return true;
    }
}
