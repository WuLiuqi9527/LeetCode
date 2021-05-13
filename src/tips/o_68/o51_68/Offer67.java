package tips.o_68.o51_68;

/**
 * <p>说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。
 * 如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
 * <p>示例 1:
 * 输入: "42"
 * 输出: 42
 * <p>示例 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * <p>示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * <p>示例 4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * <p>示例 5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * 因此返回 INT_MIN (−2^31) 。
 *
 * @author hc
 */
public class Offer67 {

    public int strToInt(String str) {
        int res = 0;
        // state == 0 初始状态 1 正数 2 负数
        int state = 0;
        for (char ch : str.toCharArray()) {
            if (state == 0 && ch == ' ') {
                continue;
            } else if (state == 0 && ch == '+') {
                state = 1;
            } else if (state == 0 && ch == '-') {
                state = 2;
            } else if ('0' <= ch && ch <= '9') {
                if (state == 0) {
                    state = 1;
                }

                int tem = ch - '0';
                if (res > (Integer.MAX_VALUE - tem) / 10) {
                    if (state == 1) {
                        return Integer.MAX_VALUE;
                    } else if (state == 2) {
                        return Integer.MIN_VALUE;
                    }
                }
                res = res * 10 + tem;
            } else {
                break;
            }
        }
        return (state & 1) == 1 ? res : -res;
    }
}
