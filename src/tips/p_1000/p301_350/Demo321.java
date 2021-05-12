package tips.p_1000.p301_350;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。
 * 现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，
 * 要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 * <p>示例 1:
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * <p>示例 2:
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * <p>示例 3:
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 *
 * @author hc
 */
public class Demo321 {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        if (nums1 == null || m == 0) {
            return pickMax(nums2, k);
        }
        if (nums2 == null || n == 0) {
            return pickMax(nums1, k);
        }

        int[] res = null;
        for (int i = Math.max(0, k - n), limit = Math.min(m, k); i <= limit; i++) {
            int[] a = pickMax(nums1, i);
            int[] b = pickMax(nums2, k - i);
            int[] c = merge(a, b);
            res = res == null || compare(res, 0, c, 0) < 0 ? c : res;
        }

        return res;
    }

    /**
     * nums数组保留 k 个数
     */
    private int[] pickMax(int[] nums, int k) {
        int len = nums.length;
        if (len == k) {
            return nums;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int drop = len - k;
        for (int num : nums) {
            while (drop > 0 && !stack.isEmpty() && stack.peekLast() < num) {
                stack.pollLast();
                --drop;
            }
            stack.add(num);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = stack.pollFirst();
        }
        return res;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] res = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            res[k++] = compare(nums1, i, nums2, j) >= 0 ? nums1[i++] : nums2[j++];
        }
        while (i < m) {
            res[k++] = nums1[i++];
        }
        while (j < n) {
            res[k++] = nums2[j++];
        }

        return res;
    }

    private int compare(int[] nums1, int i, int[] nums2, int j) {
        int m = nums1.length;
        int n = nums2.length;

        for (int k = 0, limit = Math.min(m - i, n - j); k < limit; k++) {
            if (nums1[i + k] != nums2[j + k]) {
                return Integer.compare(nums1[i + k], nums2[j + k]);
            }
        }

        return Integer.compare(m - i, n - j);
    }

    public static void main(String[] args) {
        new Demo321().pickMax(new int[]{3, 4, 6, 5}, 2);
    }
}
