package tips.p_1000.p201_250;

import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 * <p>
 * 示例 1：
 * 输入：s = "1 + 1"
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * <p>
 * 示例 3：
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * <p>
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 *
 * @author hc
 */
public class Demo224 {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        // sign 代表正负
        int sign = 1, res = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int cur = ch - '0';
                while (i + 1 < length && Character.isDigit(s.charAt(i + 1))) {
                    cur = cur * 10 + s.charAt(++i) - '0';
                }
                res = res + sign * cur;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {

                // ‘(’ 将当前的 res sign 压栈 保存当下的状态 res 先 sign 后 便于弹出栈运算
                // ')' 将上一时刻保存的状态取出
                // res = stack.pop() * res + stack.pop();
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
            } else if (ch == ')') {
                res = stack.pop() * res + stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo224().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
