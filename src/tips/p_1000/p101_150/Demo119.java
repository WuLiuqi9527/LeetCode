package tips.p_1000.p101_150;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 * @author hc
 */
public class Demo119 {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i <= rowIndex; i++) {
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
        return res.get(rowIndex);
    }

    public List<Integer> getRow2(int rowIndex) {
        // 省空间
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return Arrays.asList(dp);
    }

    public List<Integer> getRow3(int rowIndex) {
        Integer[] res = new Integer[rowIndex + 1];
        dp(res, 0, rowIndex);
        return Arrays.asList(res);
    }

    private void dp(Integer[] res, int index, int rowIndex) {
        if (index > rowIndex) {
            return;
        }

        int tem = 0;
        for (int i = 0; i <= index; i++) {
            if (i == 0 || i == index) {
                res[i] = 1;
                tem = res[i];
            } else {
                int t = res[i];
                res[i] += tem;
                tem = t;
            }
        }
        dp(res, index + 1, rowIndex);
    }

    public static void main(String[] args) {
        new Demo119().getRow3(3);
    }
}
