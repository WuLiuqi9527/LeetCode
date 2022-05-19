package tips.p_1000.p451_500;

import java.util.Arrays;
import java.util.Collections;

/**
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
 * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
 * <p>示例 1：
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：
 * 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * <p>示例 2：
 * 输入：nums = [1,10,2,9]
 * 输出：16
 * <p>提示：
 * n == nums.length
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 *
 * @author hc
 */
public class Demo462 {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int res = 0;
        while (l < r) {
            res += nums[r--] - nums[l++];
        }
        return res;
    }
}
