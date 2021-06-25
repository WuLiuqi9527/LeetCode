package tips.p_others;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k 。
 * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 * 返回你可以对数组执行的最大操作数。
 * <p>示例 1：
 * 输入：nums = [1,2,3,4], k = 5
 * 输出：2
 * 解释：开始时 nums = [1,2,3,4]：
 * - 移出 1 和 4 ，之后 nums = [2,3]
 * - 移出 2 和 3 ，之后 nums = []
 * 不再有和为 5 的数对，因此最多执行 2 次操作。
 * <p>示例 2：
 * 输入：nums = [3,1,3,4,3], k = 6
 * 输出：1
 * 解释：开始时 nums = [3,1,3,4,3]：
 * - 移出前两个 3 ，之后nums = [1,4,3]
 * 不再有和为 6 的数对，因此最多执行 1 次操作。
 * <p>提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= k <= 10^9
 *
 * @author hc
 */
public class Demo1679 {

    public int maxOperations(int[] nums, int k) {
        // 参考两数之和 使用 HashMap 优化
        List<List<Integer>> lists = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int complement = k - nums[i];
            if (map.containsKey(complement) && map.get(complement) > 0) {
                lists.add(Arrays.asList(nums[i], complement));
                map.put(complement, map.get(complement) - 1);
                continue;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return lists.size();
    }

    public int maxOperations2(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int count = 0;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == k) {
                count++;
                sum = 0;
                ++l;
                --r;
            } else if (sum < k) {
                ++l;
            } else {
                --r;
            }
        }
        return count;
    }
}
