package tips.p_1000.p1_50;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * @author hc
 */

public class Demo20 {

    public boolean isValid(String s) {
        if ((s.length() & 1) == 1) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == ')' && stack.pop() != '(') {
                    return false;
                }
                if (c == '}' && stack.pop() != '{') {
                    return false;
                }
                if (c == ']' && stack.pop() != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        // 用数组模拟栈 加快寻址
        if ((s.length() & 1) == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        char[] stack = new char[len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (c == '(' || c == '{' || c == '[') {
                stack[index++] = c;
            } else {
                if (index == 0) {
                    return false;
                }
                if (c == ')' && stack[index - 1] != '(') {
                    return false;
                }
                if (c == '}' && stack[index - 1] != '{') {
                    return false;
                }
                if (c == ']' && stack[index - 1] != '[') {
                    return false;
                }
                --index;
            }
        }
        return index == 0;
    }

    public boolean isValid3(String s) {
        // 效率太低！
        if ((s.length() & 1) == 1) {
            return false;
        }

        for (int i = s.length() >> 1; i > 0; i--) {
            s = s.replace("()", "")
                    .replace("{}", "")
                    .replace("[]", "");
        }
        return s.length() == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Demo20().isValid("()"));
        System.out.println(new Demo20().isValid("()[]{}"));
        System.out.println(new Demo20().isValid("(]"));
        System.out.println(new Demo20().isValid("([)]"));
        System.out.println(new Demo20().isValid("{[]}"));
    }
}