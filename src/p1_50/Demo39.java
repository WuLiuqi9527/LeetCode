package p1_50;

import java.util.*;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 *
 * @author hc
 */
public class Demo39 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, int index) {

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (candidates[index] > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Demo39().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
