package tips.p_1000.p401_450;

/**
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * 子数组 是数组中的一个连续序列。
 * <p>示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 * <p>示例 2：
 * 输入：nums = [1]
 * 输出：0
 * <p>提示：
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 *
 * @author hc
 */
public class Demo413 {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        // 当整个数组为 (1, 2, 3, 4, 5, 6) 的时候
        // (1, 2, 3)的等差数列的个数为 1, (1, 2, 3, 4)的等差数列的个数为 3 [1+2]
        // (1, 2, 3, 4, 5)的等差数列的个数为 6 [1+2+3], (1, 2, 3, 4, 5, 6)的等差数列个数为 10 [1+2+3+4]
        // 以此类推, 在一个等差数列中加入一个数字,如果还保持着等差数列的特性,每次的增量都会加 1
        int res = 0;
        int add = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                res += ++add;
            } else {
                add = 0;
            }
        }
        return res;
    }
}
