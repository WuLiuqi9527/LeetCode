package tips.p_1000.p901_950;

import java.util.HashMap;

/**
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * 子数组 是数组的一段连续部分。
 * <p>示例 1：
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * <p>示例 2：
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 * <p>提示：
 * 1 <= nums.length <= 3 * 10^4
 * nums[i] 不是 0 就是 1
 * 0 <= goal <= nums.length
 *
 * @author hc
 */
public class Demo930 {

    public int numSubarraysWithSum(int[] nums, int goal) {
        // 前缀和 超时
        int len = nums.length;
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int count = 0;
        for (int i = len; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (sum[i] - sum[j] == goal) {
                    ++count;
                }
            }
        }
        return count;
    }

    public int numSubarraysWithSum2(int[] nums, int goal) {
        // hashmap + 前缀和
        int len = nums.length;
        int count = 0;
        // Map<补数, 频次>
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        for (int i = 0; i < len; ++i) {
            sum += nums[i];
            if (map.containsKey(sum - goal)) {
                count += map.get(sum - goal);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public int numSubarraysWithSum3(int[] nums, int goal) {
        // 用数组代替 hashmap
        int len = nums.length;
        int[] map = new int[30001];
        map[0] = 1;
        int sum = 0, count = 0;

        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (sum >= goal) {
                count += map[sum - goal];
            }
            ++map[sum];
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Demo930().numSubarraysWithSum3(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(new Demo930().numSubarraysWithSum3(new int[]{0, 0, 0, 0, 0}, 0));
    }
}
