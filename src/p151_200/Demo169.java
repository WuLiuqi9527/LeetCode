package p151_200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * 进阶：
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * 1、暴力解法 Map<Integer, Integer>
 * 2、摩尔投票法 -> 大混战 我方人数多，兑子，活到最后的一定是我方
 * 3、大于 n/2 排序取中点
 *
 * @author hc
 */
public class Demo169 {

    public int majorityElement(int[] nums) {
        int limit = nums.length >> 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int num : map.keySet()) {
            if (map.get(num) > limit) {
                res = num;
            }
        }
        return res;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    public int majorityElement3(int[] nums) {
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
