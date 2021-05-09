package tip.p151_200;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的 连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * <p>
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * @author hc
 */
public class Demo152 {

    /**
     * 负数怎么处理？ -> 1、均为正数 直接相乘
     *                2、偶数个负数 直接相乘
     *                3、奇数个负数 第一个负数后的连续子数组 和 最后一个负数之前得连续子数组 两者得最大值
     *                   -> 正着遍历一遍，倒着遍历一遍
     *                4、有 0 存在， max = 1， 重新累乘
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max = 1;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max *= nums[i];
            res = Math.max(res, max);
            if (max == 0) {
                max = 1;
            }
        }

        max = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            max *= nums[i];
            res = Math.max(res, max);
            if (max == 0) {
                max = 1;
            }
        }

        return res;
    }
}
