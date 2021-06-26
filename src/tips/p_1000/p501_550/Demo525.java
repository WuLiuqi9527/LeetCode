package tips.p_1000.p501_550;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * <p>示例 1:
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * <p>示例 2:
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 * <p>提示：
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 *
 * @author hc
 */
public class Demo525 {

    public int findMaxLength(int[] nums) {
        int res = 0;
        int len = nums.length;

        // count维护前缀和
        int count = 0;
        // Map<num[i], 第一次出现num[i]下标> -> map<0, i> map<-1, j>
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                ++count;
            } else {
                --count;
            }
            if (map.containsKey(count)) {
                res = Math.max(res, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return res;
    }

    public int findMaxLength2(int[] nums) {
        int res = 0, sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        // Map<num[i], 第一次出现 num[i]下标> -> map<0, i> map<-1, j>
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo525().findMaxLength2(new int[]{0, 1, 0, 1, 0}));
    }
}
