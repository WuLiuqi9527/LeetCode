package tip.lt1000.p1_50;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的 最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * 假设你总是可以到达数组的最后一个位置。
 *
 * @author hc
 */
public class Demo45 {

    public int jump(int[] nums) {

        int count = 0;
        int maxPos = 0;

        /**
         * 在访问最后一个元素之前，边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。(题目要求保证)
         * 如果访问最后一个元素，在边界正好为最后一个位置的情况下，会增加一次「不必要的跳跃次数」，
         * 因此 不必访问最后一个元素
         */
        for (int i = 0, end = 0; i < nums.length - 1; i++) {

            maxPos = Math.max(maxPos, nums[i] + i);
            // 维护当前能够到达的最大下标位置，记为边界。
            // 从左到右遍历数组，到达边界时，更新边界并将跳跃次数增加 1
            if (i == end) {
                end = maxPos;
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Demo45().jump(new int[]{2, 3, 1, 1, 4}));
    }
}
