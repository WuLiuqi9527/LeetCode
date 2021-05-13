package tips.o_68.o51_68;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * <p>示例 1：
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * <p>示例 2：
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 * <p>限制：
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 *
 * @author hc
 */
public class Offer56Two {

    public int singleNumber(int[] nums) {
        // 考虑数字的二进制形式，对于出现三次的数字，各二进制位 出现的次数都是 3 的倍数
        int a = 0, b = 0;
        for (int num : nums) {
            b = (b ^ num) & ~a;
            a = (a ^ num) & ~b;
        }
        return b;
    }
}
