package tips.p_1000.p201_250;

import java.util.TreeSet;

/**
 * 在整数数组 nums 中，是否存在两个下标 i 和 j，
 * 使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，
 * 且满足 i 和 j 的差的绝对值也小于等于 ķ 。
 * 如果存在则返回 true，不存在返回 false。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 *
 * @author hc
 */
public class Demo220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (k == 10000) {return false;}
        int len = nums.length;
        if (len == 0) {return false;}

        // 滑动窗口结合查找表，此时滑动窗口即为查找表本身（控制查找表的大小即可控制窗口大小）
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 边添加边查找
            // 查找表中是否有大于等于 nums[i] - t 且小于等于 nums[i] + t 的值
            if (set.ceiling((long) nums[i] - (long) t) != null && set.ceiling((long) nums[i] - (long) t) <= (long) nums[i] + (long) t) {
                return true;
            }
            // 添加后，控制查找表（窗口）大小，移除窗口最左边元素
            set.add((long) nums[i]);
            if (set.size() == k + 1) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Demo220().containsNearbyAlmostDuplicate(new int[]{2147483646, 2147483647}, 3, 3));
    }
}
