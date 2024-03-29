package tips.p_1000.p201_250;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * @author hc
 */
public class Demo213 {

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int len = nums.length;
        // 额外两个空间 便于 i-2
        int[] dp = new int[len + 2];

        for (int i = 2; i < len + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
        }

        int tem = dp[len];

        dp[2] = 0;
        for (int i = 3; i < len + 2; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
        }

        return Math.max(dp[len + 1], tem);
    }

    public int rob2(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int len = nums.length;
        int[] dp = new int[len];

        // 不抢第一个
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int tem = dp[len - 1];

        // 不抢最后一个
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < len - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return Math.max(dp[len - 2], tem);
    }

    public static void main(String[] args) {
        System.out.println(new Demo213().rob2(new int[]{2, 3, 2}));
    }
}
