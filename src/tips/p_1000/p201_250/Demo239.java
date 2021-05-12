package tips.p_1000.p201_250;

import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * <p>示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * <p>示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>示例 3：
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * <p>示例 4：
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * <p>示例 5：
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 * <p>提示：
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 * @author hc
 */
public class Demo239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 超时
        int len = nums.length;
        if (nums == null || len == 0) {
            return new int[0];
        }

        int[] res = new int[len - k + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < res.length; i++) {
            for (int j = i; j < i + k; j++) {
                max = max < nums[j] ? nums[j] : max;
            }
            res[i] = max;
            max = Integer.MIN_VALUE;
        }
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数按从大到小排序
        LinkedList<Integer> list = new LinkedList();

        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小 弹出
            while (!list.isEmpty() && nums[list.peekLast()] <= nums[i]) {
                list.pollLast();
            }
            // 添加当前值对应的数组下标
            list.addLast(i);
            // 初始化窗口 等到窗口长度为k时 下次移动在删除过期数值
            if (list.peek() <= i - k) {
                list.poll();
            }
            // 窗口长度为k时 再保存当前窗口中最大值
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[list.peek()];
            }
        }
        return result;
    }
}
