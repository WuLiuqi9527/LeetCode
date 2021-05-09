package tip.p51_100;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 *
 * @author hc
 */
public class Demo55 {

    public boolean canJump(int[] nums) {

        if (nums.length <= 1) {
            return true;
        }

        // 覆盖范围 i + num[i] 是否能覆盖整个数组
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean canJump2(int[] nums) {

        if (nums.length <= 1) {
            return true;
        }

        int maxDis = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (i <= maxDis) {
                maxDis = Math.max(maxDis, i + nums[i]);
            }
        }

        return maxDis >= len - 1;
    }

    public boolean canJump3(int[] nums) {

        if (nums.length <= 1) {
            return true;
        }

        int maxRight = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= maxRight) {
                maxRight = i;
            }
        }

        return maxRight == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Demo55().canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
