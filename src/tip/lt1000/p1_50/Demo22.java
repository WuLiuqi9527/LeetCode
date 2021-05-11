package tip.lt1000.p1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * 提示：
 * 1 <= n <= 8
 *
 * @author hc
 */
public class Demo22 {

    List<String> res;

    public List<String> generateParenthesis(int n) {

        if (n < 1 || n > 8) {
            throw new IllegalArgumentException("输入错误");
        }

        res = new ArrayList<>();

        dfs(n, n, "");
        return res;
    }

    private void dfs(int l, int r, String str) {

        if (l == 0 && r == 0) {
            res.add(new String(str));
            return;
        }

        if (l > 0) {
            dfs(l - 1, r, str + "(");
        }

        if (r > l) {
            dfs(l, r - 1, str + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println(new Demo22().generateParenthesis(3));
    }
}
