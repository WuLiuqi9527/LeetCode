package tips.p_1000.p201_250;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * <p>
 * 在 1-9 之中选择 k 个数 使其相加之和为 n 每个数只能选择一次
 *
 * @author hc
 */
public class Demo216 {

    List<List<Integer>> lists;
    List<Integer> list;

    public List<List<Integer>> combinationSum3(int k, int n) {

        lists = new ArrayList<>();
        list = new ArrayList<>();
        dfs(k, n, 1);
        return lists;
    }

    private void dfs(int k, int n, int index) {

        // 结束条件 k==0 && n==0
        if (k == 0 && n == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }

        // 只允许 1-9
        if (k <= 0 || n <= 0) {
            return;
        }

        for (int i = index; i < 10; i++) {
            list.add(i);
            // i+1 已经保证了不会重复 (1-9)
            dfs(k - 1, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        System.out.println(new Demo216().combinationSum3(3, 7));
    }
}
