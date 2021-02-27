package problemset;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * @author hc
 */
public class Demo150 {

    public int evalRPN(String[] tokens) {

        Deque<Character> deque = new ArrayDeque<>();
        for (String str : tokens) {
            for (char c : str.toCharArray()) {
                if (0 <= c - '0' && c - '0' <= 9){

                }
            }
        }

        return -1;
    }
}
