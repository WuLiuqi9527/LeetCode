package tips.p_1000.p451_500;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
 * 现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 - 中选择一个符号添加在前面。
 * 返回可以使最终 数组和 为目标数 S 的所有添加符号的方法数。
 * <p>
 * 示例：
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 一共有5种方法让最终目标和为3。
 *
 * @author hc
 */
public class Demo494 {

    /**
     * 动态规划
     */
    public int findTargetSumWays(int[] nums, int target) {

        /**
         * sum(P) - sum(N) = target
         * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
         * 2 * sum(P) = target + sum(nums)
         * 问题转化为能否在 nums 中找到一个子集 P，使得 sum(P) = (target + sum(nums)) >>> 1
         */
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum < target || ((sum + target) & 1) != 0) {
            return 0;
        }

        // dp[i]代表 从nums中取数相加和为 i 时有多少种取法
        int p = (sum + target) >> 1;
        int[] dp = new int[p + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = p; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[p];
    }

    /**
     * 回溯
     */
    private int count = 0;

    public int findTargetSumWays2(int[] nums, int target) {
        back(nums, target, 0, 0);
        return count;
    }

    private void back(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (target == sum) {
                ++count;
            }
        } else {
            back(nums, target, index + 1, sum + nums[index]);
            back(nums, target, index + 1, sum - nums[index]);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Demo494().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
