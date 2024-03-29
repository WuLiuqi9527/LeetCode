package tips.o_68.o1_50;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为 O(n)。
 * <p>示例 1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>提示：
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * @author hc
 */
public class Offer42 {

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum = sum < 0 ? num : sum + num;
            res = Math.max(res, sum);
        }
        return res;
    }
}
