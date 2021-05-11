package tip.lt1000.p451_500;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个整数序列：a1, a2, ..., an，
 * 一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。
 * 设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有 132 模式的子序列。
 * 注意：n 的值小于15000。
 * <p>
 * 示例1:
 * 输入: [1, 2, 3, 4]
 * 输出: False
 * 解释: 序列中不存在132模式的子序列。
 *
 * @author hc
 */
public class Demo456 {

    public boolean find132pattern(int[] nums) {

        int len = nums.length;
        if (len < 3) {
            return false;
        }

        //min[i]表示 nums[0]到nums[i]的最小值
        int[] min = new int[len];
        min[0] = nums[0];
        for (int i = 1; i < len; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        Deque<Integer> stack = new LinkedList<>();
        stack.push(nums[len - 1]);
        for (int j = len - 2; j >= 1; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j]) {
                    stack.pop();
                }
                //此时栈顶元素一定大于 min[j]
                if (!stack.isEmpty() && nums[j] > stack.peek()) {
                    return true;
                }
                stack.push(nums[j]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Demo456().find132pattern(new int[]{1, 2, 3, 4}));
    }
}
