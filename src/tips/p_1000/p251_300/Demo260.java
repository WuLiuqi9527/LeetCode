package tips.p_1000.p251_300;

/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
 * 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * <p>
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * <p>
 * 提示：
 * 2 <= nums.length <= 3 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 除两个只出现一次的整数外，nums 中的其他数字都出现两次
 *
 * @author hc
 */
public class Demo260 {

    public int[] singleNumber(int[] nums) {

        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // 找到两个数不相同的一个二进制位
        int bit = 1;
        while ((xor & 1) == 0) {
            xor >>= 1;
            bit <<= 1;
        }

        // 以该二进制位将数组分成两部分，再做异或 其余数字在两部分中均为 0 or 2
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & bit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        new Demo260().singleNumber(new int[]{1,2,1,3,2,5});
    }
}
