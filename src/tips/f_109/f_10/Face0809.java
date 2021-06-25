package tips.f_109.f_10;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 * 说明：解集不能包含重复的子集。
 * <p>例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author hc
 */
public class Face0809 {

    List<String> list;

    public List<String> generateParenthesis(int n) {

        list = new ArrayList<>();
        dfs(n, n, new StringBuilder());
        return list;
    }

    private void dfs(int left, int right, StringBuilder sb) {
        if (left == 0 && right == 0) {
            list.add(sb.toString());
            return;
        }
        if (left > right) {
            return;
        }

        if (left > 0) {
            sb.append("(");
            dfs(left - 1, right, sb);
            sb.setLength(sb.length() - 1);
        }
        if (right > 0) {
            sb.append(")");
            dfs(left, right - 1, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
