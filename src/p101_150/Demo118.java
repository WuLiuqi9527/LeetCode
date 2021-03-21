package p101_150;

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
                List<Integer> tem = res.get(i - 1);
                int len = tem.size() + 1;

                for (int j = 0; j < len; j++) {
                    if (j == 0 || j == len - 1) {
                        list.add(1);
                    } else {
                        list.add(tem.get(j - 1) + tem.get(j));
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
}
