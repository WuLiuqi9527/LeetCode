package tips.f_109;

/**
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 * <p>示例：
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>进阶：
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * @author hc
 */
public class Face1617 {

    public int maxSubArray(int[] nums) {

        int sum = 0, max = Integer.MIN_VALUE;
        int len = nums.length;
        int index = 0;
        while (index < len) {
            if (sum + nums[index] < nums[index]) {
                sum = 0;
            }
            sum = sum + nums[index];
            if (sum > max) {
                max = sum;
            }
            ++index;
        }
        return max;
    }
}
