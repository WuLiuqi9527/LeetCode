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

    public int findTargetSumWays(int[] nums, int S) {

        /**
         * 2 * sum(P) = S + sum(nums)
         * 问题转化为能否在 nums 中找到和为 (S + sum(nums)) >>> 1 的子集
         */
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return (sum < S) || ((S + sum) & 1) != 0 ? 0 : findTarget(nums, (S + sum) >>> 1);
    }

    private int findTarget(int[] nums, int s) {

        /**
         *  dp[i]代表 从nums中取数相加和为 i 时有多少种取法
         */
        int[] dp = new int[s+1];
        dp[0] = 1;

        for(int num:nums){
            for (int i = s; i >= num; i--) {
                dp[i] = dp[i] + dp[i-num];
            }
        }

        return dp[s];
    }

    public static void main(String[] args) {
        System.out.println(new Demo494().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
