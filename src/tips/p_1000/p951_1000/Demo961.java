package tips.p_1000.p951_1000;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，该数组具有以下属性：
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 * <p>示例 1：
 * 输入：nums = [1,2,3,3]
 * 输出：3
 * <p>示例 2：
 * 输入：nums = [2,1,2,5,3,2]
 * 输出：2
 * <p>示例 3：
 * 输入：nums = [5,1,5,2,5,3,5,4]
 * 输出：5
 * <p>提示：
 * 2 <= n <= 5000
 * nums.length == 2 * n
 * 0 <= nums[i] <= 10^4
 * nums 由 n + 1 个 不同的 元素组成，且其中一个元素恰好重复 n 次
 *
 * @author hc
 */
public class Demo961 {

    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len >> 1] == nums[len / 2 + 1] ? nums[len >> 1] : nums[len / 2 - 1];
    }

    public int repeatedNTimes2(int[] nums) {
        ArrayList<Integer> integers = new ArrayList<>(2);
        for (int i = 0; i <= nums.length; i++) {
            if (integers.contains(nums[i])) {
                return nums[i];
            } else {
                integers.add(nums[i]);
            }
        }
        return 0;
    }
}
