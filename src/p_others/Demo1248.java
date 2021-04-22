package p_others;

import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 k。
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。
 * <p>示例 1：
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * <p>示例 2：
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * <p>示例 3：
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 * <p>提示：
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 *
 * @author hc
 */
public class Demo1248 {

    public int numberOfSubarrays(int[] nums, int k) {
        // 前缀和 + hashmap
        // hashmap<奇数个数, 出现次数>
        HashMap<Integer, Integer> map = new HashMap<>();
        // 初始化 0个奇数 出现一次
        map.put(0, 1);
        int countOdd = 0;
        int res = 0;
        for (int num : nums) {
            if ((num & 1) == 1) {
                ++countOdd;
            }
            if (map.containsKey(countOdd - k)) {
                res += map.get(countOdd - k);
            }
            map.put(countOdd, map.getOrDefault(countOdd, 0) + 1);
        }

        return res;
    }

    public int numberOfSubarrays2(int[] nums, int k) {
        // 使用 数组模拟 hashmap 线性内存地址 加快速度 map[奇数个数] = 出现频次
        int len = nums.length;
        int[] map = new int[len + 1];
        map[0] = 1;
        int countOdd = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            countOdd += nums[i] & 1;
            if (countOdd - k >= 0) {
                res += map[countOdd - k];
            }
            ++map[countOdd];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo1248().numberOfSubarrays2(new int[]{1, 1, 2, 1, 1}, 3));
        System.out.println(new Demo1248().numberOfSubarrays2(new int[]{2, 4, 6}, 1));
        System.out.println(new Demo1248().numberOfSubarrays2(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
    }
}
