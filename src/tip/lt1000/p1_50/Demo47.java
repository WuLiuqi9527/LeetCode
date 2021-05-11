package tip.lt1000.p1_50;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 *
 * @author hc
 */
public class Demo47 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int cur) {

        if (cur == nums.length) {
            List<Integer> path = new ArrayList<>();
            for (int num : nums) {
                path.add(num);
            }
            res.add(path);
        }

        for (int i = cur; i < nums.length; i++) {
            if (canSwap(nums, cur, i)) {
                swap(nums, cur, i);
                dfs(nums, cur + 1);
                // 回溯 还原现场
                swap(nums, cur, i);
            }
        }
    }

    private boolean canSwap(int[] nums, int begin, int end) {
        for (int i = begin; i < end; i++) {
            // 不等 才能交换
            if (nums[i] == nums[end]) {
                return false;
            }
        }
        return true;
    }

    private void swap(int[] nums, int l, int r) {
        int tem = nums[l];
        nums[l] = nums[r];
        nums[r] = tem;
    }

    public static void main(String[] args) {
        System.out.println(new Demo47().permuteUnique(new int[]{1, 1, 2}));
    }
}
