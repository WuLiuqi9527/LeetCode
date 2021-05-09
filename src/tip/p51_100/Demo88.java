package tip.p51_100;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * <p>
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 * @author hc
 */
public class Demo88 {

    /**
     * 1、普通递归
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    /**
     * 2、时间复杂度 O(m+n) 无需额外空间
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {

        int m1 = m - 1;
        int n1 = n - 1;
        int p1 = m + n - 1;
        while (m1 >= 0 && n1 >= 0) {
            nums1[p1--] = nums1[m1] > nums2[n1] ? nums1[m1--] : nums2[n1--];
        }

        // nums2 多出来的部分(有序)直接放到 nums1 的前面
        System.arraycopy(nums2, 0, nums1, 0, n1 + 1);
    }

    public static void main(String[] args) {
        new Demo88().merge2(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}
