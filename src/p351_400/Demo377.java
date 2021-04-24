package p351_400;

import java.util.Arrays;

/**
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 * <p>
 * 示例:
 * nums = [1, 2, 3]
 * target = 4
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 因此输出为 7。
 *
 * @author hc
 */
public class Demo377 {

    public int combinationSum41(int[] nums, int target) {

        /**
         * 简单递归 超时
         * if(){递归终止}
         *      ... // 递归处理
         */
        if (target == 0) {
            return 1;
        }

        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += combinationSum41(nums, target - num);
            }
        }
        return res;
    }

    public int combinationSum42(int[] nums, int target) {

        /**
         * 记忆化搜索
         */
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;

        return search(nums, target, memo);
    }

    private int search(int[] nums, int target, int[] memo) {
        if (memo[target] != -1) {
            return memo[target];
        }

        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += search(nums, target - num, memo);
            }
        }
        memo[target] = res;
        return res;
    }

    public int combinationSum43(int[] nums, int target) {

        /**
         * 动态规划
         */
        int[] dp = new int[target + 1];
        // 推导递推公式 本身值为多少无意义
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                // i 为 target 的剩余值
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }
}
