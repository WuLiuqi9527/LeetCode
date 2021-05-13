package tips.o_68.o51_68;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>示例 1：
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * <p>示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * <p>限制：
 * 2 <= nums.length <= 10000
 *
 * @author hc
 */
public class Offer56One {

    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int bit = 1;
        while ((xor & 1) == 0) {
            xor >>= 1;
            bit <<= 1;
        }

        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((bit & num) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }
}
