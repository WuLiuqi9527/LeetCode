package tips.p_1000.p701_750;

/**
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i]，删除它并获得 nums[i] 的点数。之后，你必须删除 【每个】 等于 nums[i] - 1 或 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>示例 1：
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * <p>示例 2：
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * <p>提示：
 * 1 <= nums.length <= 2 * 10^4
 * 1 <= nums[i] <= 10^4
 *
 * @author hc
 */
public class Demo740 {

    /**
     * 打家劫舍 1   dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
     * 的变种      dp[i] = Math.max(dp[i - 1], dp[i - 2] + all[i]);
     * num -> all
     *              all[num[i]] += num[i];
     */
    public int deleteAndEarn(int[] nums) {
        int[] all = new int[10001];
        for (int num : nums) {
            all[num] += num;
        }

        int[] dp = new int[10001];
        dp[0] = 0;
        dp[1] = all[1];
        for (int i = 2; i < 10001; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + all[i]);
        }

        return dp[10000];
    }
}
