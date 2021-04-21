package o1_50;

import java.util.Arrays;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * <p>限制：
 * 1 <= 数组长度 <= 50000
 *
 * @author hc
 */
public class Offer39 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    public int majorityElement2(int[] nums) {
        int res = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
                ++count;
            } else {
                count = res == num ? count + 1 : count - 1;
            }
        }
        return res;
    }
}
