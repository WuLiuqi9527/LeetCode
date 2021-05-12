package tips.p_1000.p251_300;

import java.util.Arrays;

/**
 * 给定一个包含vn + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * <p>示例 1：
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * <p>提示：
 * 2 <= n <= 3 * 10^4
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 * <p>进阶：
 * 如何证明 nums 中至少存在一个重复的数字?
 * 你可以在不修改数组 nums 的情况下解决这个问题吗？
 * 你可以只用常量级 O(1) 的额外空间解决这个问题吗？
 * 你可以设计一个时间复杂度小于 O(n^2) 的解决方案吗？
 *
 * @author hc
 */
public class Demo287 {

    public int findDuplicate(int[] nums) {
        // 空间复杂度 O(n) 时间复杂度 O(n)
        int len = nums.length;
        int[] used = new int[len];
        for (int i = 0; i < len; i++) {
            ++used[nums[i]];
        }

        for (int i = 1; i < len; i++) {
            if (used[i] > 1) {
                return i;
            }
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {
        // 空间 O(1) 默认快排 时间复杂度 O(nlogn)
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i-1] == nums[i]) {
                return nums[i];
            }
        }
        return -1;
    }

    public int findDuplicate3(int[] nums) {
        // 快慢指针 重复成环
        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow){
                break;
            }
        }
        // 慢指针走了 n-m 步，m 为 到环的距离
        // 慢指针再向前走 m 步正好走到环入口 即重复的数
        int res = 0;
        while (true) {
            res = nums[res];
            slow = nums[slow];
            if (res == slow) {
                break;
            }
        }
        return res;
    }

        public static void main(String[] args) {
        System.out.println(new Demo287().findDuplicate3(new int[]{1, 3, 4, 2, 2}));
    }
}
