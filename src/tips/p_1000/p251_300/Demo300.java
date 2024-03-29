package tips.p_1000.p251_300;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * @author hc
 */
public class Demo300 {

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }

        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, memo[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo300().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
