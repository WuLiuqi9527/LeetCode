package tips.p_1000.p901_950;

/**
 * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
 * 返回满足此条件的 任一数组 作为答案。
 * <p>示例 1：
 * 输入：nums = [3,1,2,4]
 * 输出：[2,4,3,1]
 * 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
 * <p>示例 2：
 * 输入：nums = [0]
 * 输出：[0]
 * <p>提示：
 * 1 <= nums.length <= 5000
 * 0 <= nums[i] <= 5000
 *
 * @author hc
 */
public class Demo905 {

    public static int[] sortArrayByParity(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }

        for (int i = 0, j = nums.length - 1; i < j; i++) {
            if ((nums[i] & 1) == 1) {
                int tem = nums[j];
                nums[j--] = nums[i];
                nums[i--] = tem;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = sortArrayByParity(new int[]{0, 2});
        for (int a : arr) {
            System.out.print(a + "\t");
        }
    }
}
