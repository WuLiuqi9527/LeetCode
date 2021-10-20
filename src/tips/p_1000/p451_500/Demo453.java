package tips.p_1000.p451_500;

/**
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 * <p>示例 1：
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要 3 次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * <p>示例 2：
 * 输入：nums = [1,1,1]
 * 输出：0
 * <p>提示：
 * n == nums.length
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 答案保证符合 32-bit 整数
 *
 * @author hc
 */
public class Demo453 {

    public int minMoves(int[] nums) {
        int n = nums.length;
        long min = nums[0], sum = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }
        return (int) (sum - min * n);
    }
}
