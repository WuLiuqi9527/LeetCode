package p_contest;

import java.util.Arrays;

/**
 * 元素的 频数 是该元素在一个数组中出现的次数。
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 * <p>示例 1：
 * 输入：nums = [1,2,4], k = 5
 * 输出：3
 * 解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
 * 4 是数组中最高频元素，频数是 3 。
 * <p>示例 2：
 * 输入：nums = [1,4,8,13], k = 5
 * 输出：2
 * 解释：存在多种最优解决方案：
 * - 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
 * - 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
 * - 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
 * <p>示例 3：
 * 输入：nums = [3,9,6], k = 2
 * 输出：1
 * <p>提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= 10^5
 *
 * @author hc
 */
public class Demo5739 {

    /**
     * 排序 + 双指针。
     * 因为只有 +1 操作，所以我们只可能获得更多的大元素。
     * 因此，我们首先将数组升序排列。
     * 之后，我们采用双指针来考虑操作次数的限制。
     * 如果将当前区间内的元素全都变为区间右端点所需的操作次数超过 k，我们就将区间左端点右移。
     * <p>时间复杂度 O(NlogN)，因为我们需要对数组进行排序。
     * 空间复杂度 O(1)。
     */
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0, len = nums.length;
        int sum = 0;
        int l = 0;
        for (int r = 0; r < len; ++r) {
            sum += nums[r];
            while (nums[r] * (r - l + 1) - sum > k) {
                sum -= nums[l];
                ++l;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo5739().maxFrequency(new int[]{1, 2, 4}, 5));
        System.out.println(new Demo5739().maxFrequency(new int[]{1, 4, 8, 13}, 5));
        System.out.println(new Demo5739().maxFrequency(new int[]{3, 9, 6}, 2));
    }
}
