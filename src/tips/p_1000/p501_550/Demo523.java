package tips.p_1000.p501_550;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 * <p>示例 1：
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 * <p>示例 2：
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 * <p>示例 3：
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 * <p>提示：
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 * 0 <= sum(nums[i]) <= 2^31 - 1
 * 1 <= k <= 2^31 - 1
 *
 * @author hc
 */
public class Demo523 {

    /**
     * 暴力法
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        // 构建前缀数组
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        // 遍历寻找结果
        for (int i = 0; i < len; i++) {
            for (int j = i + 2; j <= len; j++) {
                int part = sum[j] - sum[i];
                if (part % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * set
     */
    public boolean checkSubarraySum2(int[] nums, int k) {

        int len = nums.length;
        // 前缀和
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= len; i++) {
            set.add(sum[i - 2] % k);
            if (set.contains(sum[i] % k)) {
                return true;
            }
        }
        return false;
    }

    /**
     * map
     */
    public boolean checkSubarraySum3(int[] nums, int k) {
        int len = nums.length;
        // 构建前缀数组
        int[] sum = new int[len + 1];
        Map<Integer, Integer> need = new HashMap<>();
        need.put(0, 0);
        for (int i = 1; i <= len; i++) {
            sum[i] = (sum[i - 1] + nums[i - 1]) % k;
            if (need.containsKey(sum[i])) {
                if (i - need.get(sum[i]) >= 2) {
                    return true;
                }
            } else {
                need.put(sum[i], i);
            }
        }
        return false;
    }

    /**
     * 改编：蓝桥杯 【K倍区间】
     */
    public int checkSubarraySum4(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int res = 0;
        for (int i = 1; i <= len; i++) {
            int u = sum[i] % k;
            if (map.containsKey(u)) {
                res += map.get(u);
            }
            map.put(u, map.getOrDefault(u, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo523().checkSubarraySum3(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(new Demo523().checkSubarraySum3(new int[]{23, 2, 6, 4, 7}, 6));
        System.out.println(new Demo523().checkSubarraySum3(new int[]{23, 2, 6, 4, 7}, 13));
        System.out.println(new Demo523().checkSubarraySum3(new int[]{5, 0, 0, 0}, 3));
        System.out.println(new Demo523().checkSubarraySum4(new int[]{1, 2, 3, 4, 5}, 2));
        System.out.println(new Demo523().checkSubarraySum4(new int[]{5, 6, 3, 4, 8}, 2));
    }
}
