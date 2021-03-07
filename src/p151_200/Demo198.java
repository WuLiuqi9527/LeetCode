package p151_200;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * @author hc
 */
public class Demo198 {

    public int rob(int[] nums) {
        return tryRob(nums);
    }

    private int tryRob(int[] nums) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                dp[i] = Math.max(dp[i], nums[j] + (j - 2 >= 0 ? dp[j - 2] : 0));
            }
        }

        return dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Demo198().rob(new int[]{114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240}));
    }
}
