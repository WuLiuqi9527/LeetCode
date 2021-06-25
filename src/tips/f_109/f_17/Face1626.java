package tips.f_109.f_17;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。
 * <p>示例 1:
 * 输入: "3+2*2"
 * 输出: 7
 * <p>示例 2:
 * 输入: " 3/2 "
 * 输出: 1
 * <p>示例 3:
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * <p>说明：
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 * @author hc
 */
public class Face1626 {

    public int calculate(String s) {
        int num = 0, res = 0;
        char sign = '+';
        Deque<Integer> numStack = new LinkedList<>();

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
}
