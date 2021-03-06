package p501_550;

import java.util.Arrays;

/**
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，
 * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * <p>
 * 示例 1:
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 *
 * @author hc
 */
public class Demo503 {

    public int[] nextGreaterElements(int[] nums) {
        // stack数组栈，top栈顶指针
        int len = nums.length, top = -1;
        int[] res = new int[len], stack = new int[len];
        Arrays.fill(res, -1);
        for (int i = 0; i < len << 1; i++) {
            // i % len 数组循环
            int num = nums[i % len];
            while (top > -1 && num > nums[stack[top]]) {
                res[stack[top--]] = num;
            }
            // 压入栈的是 nums 数组下标
            stack[++top] = i % len;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new Demo503().nextGreaterElements(new int[]{1, 2, 1});
        for (int i : arr) {
            System.out.print(" ");
            System.out.print(i);
        }
    }
}
