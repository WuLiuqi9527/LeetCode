/**
 * @author hc
 */
public class DayDemo {

    public int rob(int[] nums) {

        // 环形
        int len = nums.length;

        if (len == 0) {return 0;}
        if (len == 1) {return nums[0];}

        int[] dp = new int[len];

        // not contain first
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int tem = dp[len - 1];

        // not contain last
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        for (int i = 2; i < len - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return Math.max(dp[len - 2], tem);
    }

    public static void main(String[] args) {
        System.out.println(new DayDemo().rob(new int[]{2, 3, 2}));
        System.out.println(new DayDemo().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new DayDemo().rob(new int[]{0}));
    }
}