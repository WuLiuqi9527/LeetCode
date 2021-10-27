package tips.p_1000.p301_350;

import java.util.*;

/**
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 * <p>示例 1：
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 * <p>示例 2：
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 * <p>示例 3：
 * 输入：s = ")("
 * 输出：[""]
 * <p>提示：
 * 1 <= s.length <= 25
 * s 由小写英文字母以及括号 '(' 和 ')' 组成
 * s 中至多含 20 个括号
 *
 * @author hc
 */
public class Demo301 {

    private boolean isValid(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++cnt;
            } else if (c == ')') {
                --cnt;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }

    public List<String> removeInvalidParentheses(String s) {
        // bfs
        List<String> ans = new ArrayList<>();
        // 用于存储裁剪后的元素，防止重复元素加入队列
        Set<String> set = new HashSet<>();
        if (isValid(s)) {
            ans.add(s);
            return ans;
        }
        // 判断是否找到了有效字符串
        boolean isFound = false;
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (isValid(cur)) {
                ans.add(cur);
                isFound = true;
            }
            if (isFound) {
                continue;
            }
            for (int i = 0; i < cur.length(); i++) {
                char c = cur.charAt(i);
                // 只对'('或')'进行裁剪
                if (c == '(' || c == ')') {
                    String str;
                    if (i == cur.length() - 1) {
                        str = cur.substring(0, cur.length() - 1);
                    } else {
                        str = cur.substring(0, i) + cur.substring(i + 1);
                    }
                    if (set.add(str)) {
                        queue.offer(str);
                    }
                }
            }
        }
        if (ans.isEmpty()) {
            ans.add("");
        }
        return ans;
    }
}
