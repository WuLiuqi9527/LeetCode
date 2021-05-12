package tips.o51_100;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个 递增 排序的数组和一个数字 s ，在数组中查找两个数，使得它们的和正好是 s。
 * 如果有多对数字的和等于 s ，则输出任意一对即可。
 * <p>示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * <p>示例 2：
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * <p>限制：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 *
 * @author hc
 */
public class Offer57One {

    public int[] twoSum(int[] nums, int target) {

        // Map 查找表
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                // 互补的部分在前面：不断往里添加 所以是往前找
                return new int[]{complement, nums[i]};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum2(int[] nums, int target) {
        // 双指针
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum > target) {
                --right;
            } else {
                ++left;
            }
        }
        return new int[]{-1, -1};
    }
}
