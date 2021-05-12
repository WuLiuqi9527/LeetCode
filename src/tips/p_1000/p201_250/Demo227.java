package tips.p_1000.p201_250;

import java.util.Stack;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * <p>
 * 示例 1：
 * 输入：s = "3+2*2"
 * 输出：7
 * <p>
 * 示例 2：
 * 输入：s = " 3/2 "
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *
 * @author hc
 */
public class Demo227 {

    public int calculate(String s) {
        // 保存上一个符号，初始为 +
        char sign = '+';
        Stack<Integer> numStack = new Stack<>();
        // 保存当前数字，如：12是两个字符，需要进位累加
        int num = 0;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {

            char cur = s.charAt(i);
            if (cur >= '0') {
                // 记录当前数字。先减，防溢出
                num = num * 10 - '0' + cur;
            }
            if ((cur < '0' && cur != ' ') || i == s.length() - 1) {
                // 判断上一个符号是什么
                switch (sign) {
                    // 当前符号前的数字直接压栈
                    case '+':
                        numStack.push(num);
                        break;
                    // 当前符号前的数字取反压栈
                    case '-':
                        numStack.push(-num);
                        break;
                    // 数字栈栈顶数字出栈，与当前符号前的数字相乘，结果值压栈
                    case '*':
                        numStack.push(numStack.pop() * num);
                        break;
                    // 数字栈栈顶数字出栈，除于当前符号前的数字，结果值压栈
                    case '/':
                        numStack.push(numStack.pop() / num);
                        break;
                    default:
                        break;
                }
                // 记录当前符号
                sign = cur;
                // 数字清零
                num = 0;
            }
        }
        // 将栈内剩余数字累加，即为结果
        while (!numStack.isEmpty()) {
            res += numStack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo227().calculate(" 3+5 / 2 "));
    }
}
