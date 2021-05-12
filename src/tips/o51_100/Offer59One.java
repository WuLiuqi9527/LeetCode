package tips.o51_100;

import java.util.LinkedList;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * 滑动窗口的位置                  最大值
 * ---------------               -----
 * [1 3  -1] -3  5  3  6  7      3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>提示：
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * @author hc
 */
public class Offer59One {

    public int[] maxSlidingWindow(int[] nums, int k) {
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
        // 链表(底层双向链表) 模拟双端队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数按从大到小排序
        LinkedList<Integer> list = new LinkedList();

        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小 弹出
            while (!list.isEmpty() && nums[list.peekLast()] <= nums[i]) {
                list.pollLast();
            }
            // 添加当前值对应的数组下标
            list.addLast(i);
            // 初始化窗口 等到窗口长度为k时 下次移动再删除过期数值
            if (list.peek() <= i - k) {
                list.poll();
            }
            // 窗口长度为 k 时 再保存当前窗口中最大值
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[list.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Offer59One().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}
