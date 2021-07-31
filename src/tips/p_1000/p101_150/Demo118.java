package tips.p_1000.p101_150;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * 输入: 5
 * 输出:
 *
 * @author hc
 */
public class Demo118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new LinkedList<>();
            if (i == 0) {
                list.add(1);
            } else {
                addList(res, list, i);
            }
            res.add(list);
        }
        return res;
    }

    private void addList(List<List<Integer>> res, List<Integer> list, int i) {
        List<Integer> tem = res.get(i - 1);
        for (int j = 0; j <= tem.size(); j++) {
            if (j == 0 || j == tem.size()) {
                list.add(1);
            } else {
                list.add(tem.get(j - 1) + tem.get(j));
            }
        }
    }
}
