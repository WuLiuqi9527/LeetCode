package tips.p_others;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号。
 * <p>示例 1：
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * <p>示例 2：
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * <p>示例 3：
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * <p>示例 4：
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 * <p>提示：
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 *
 * @author hc
 */
public class Demo1190 {

    /**
     * 字符串反转 栈操作
     */
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    /**
     * 优化 预处理括号
     */
    public String reverseParentheses2(String s) {
        int n = s.length();
        // 存储对应左右括号的位置
        int[] pair = new int[n];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuffer sb = new StringBuffer();
        int index = 0, step = 1;
        while (index < n) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = pair[index];
                step = -step;
            } else {
                sb.append(s.charAt(index));
            }
            index += step;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Demo1190().reverseParentheses2("a(bcdefghijkl(mno)p)q"));
    }
}
