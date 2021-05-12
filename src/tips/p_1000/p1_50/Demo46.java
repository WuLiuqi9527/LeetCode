package tips.p_1000.p1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * @author hc
 */
public class Demo46 {

    List<List<Integer>> res;
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();

        if (nums.length == 0) {
            return res;
        }

        used = new boolean[nums.length];
        List<Integer> p = new ArrayList<>();

        generatePermutation(nums, 0, p);
        return res;
    }

    private void generatePermutation(int[] nums, int depth, List<Integer> p) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(p));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                p.add(nums[i]);
                used[i] = true;
                generatePermutation(nums,depth + 1, p);
                used[i] = false;
                p.remove(p.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(new Demo46().permute(new int[]{1, 2, 3}));
    }
}
