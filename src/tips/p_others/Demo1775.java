package tips.p_others;

import java.util.Arrays;

/**
 * 给你两个长度可能不等的整数数组 nums1 和 nums2。两个数组中的所有值都在1到6之间（包含1和6）。
 * 每次操作中，你可以选择 任意数组中的任意一个整数，将它变成 1到 6之间 任意的值（包含 1和 6）。
 * 请你返回使 nums1 中所有数的和与 nums2中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1。
 * <p>示例 1：
 * 输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * <p>示例 2：
 * 输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
 * 输出：-1
 * 解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
 * <p>示例 3：
 * 输入：nums1 = [6,6], nums2 = [1]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
 * - 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
 * - 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
 * <p>提示：
 * 1 <= nums1.length, nums2.length <= 105
 * 1 <= nums1[i], nums2[i] <= 6
 */
public class Demo1775 {

    public int minOperations(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length, ans = 0;
        if (n1 * 6 < n2 || n2 * 6 < n1) return -1;
        int diff = Arrays.stream(nums1).sum() - Arrays.stream(nums2).sum();
        if (diff < 0) return minOperations(nums2, nums1); //大的数组在前
        int[] mp = new int[6];
        for (int x : nums1) mp[x - 1]++; //大数组的每个数可以减少的量
        for (int x : nums2) mp[6 - x]++; //小数组的每个数可以增加的量
        for (int i = 5; i >= 1 && diff > 0; i--) {
            while (mp[i] > 0 && diff > 0) {
                diff -= i;
                mp[i]--;
                ans++;
            }
        }
        return ans;
    }

}
