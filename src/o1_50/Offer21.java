package o1_50;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>提示：
 * 0 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * @author hc
 */
public class Offer21 {

    public int[] exchange(int[] nums) {

        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && (nums[left] & 1) == 1) {
                ++left;
            }
            while (left < right && (nums[right] & 1) == 0) {
                --right;
            }
            if (left < right) {
                int tem = nums[left];
                nums[left] = nums[right];
                nums[right] = tem;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(new Offer21().exchange(new int[]{1, 3, 5}));
        System.out.println(new Offer21().exchange(new int[]{1, 2, 3, 4}));
    }
}
