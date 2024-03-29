package tips.p_1000.p1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 *
 * @author hc
 */
public class Demo40 {

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return lists;
    }

    private void dfs(int[] candidates, int target, int index) {
        // 回溯算法 不可重复
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }

        if (index >= candidates.length || candidates[index] > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // 去重
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        System.out.println(new Demo40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
