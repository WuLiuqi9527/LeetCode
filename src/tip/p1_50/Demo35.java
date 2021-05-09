package tip.p1_50;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * @author hc
 */
public class Demo35 {

    public int searchInsert(int[] nums, int target) {

        // 返回的是 target 的位置
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    public int searchInsert2(int[] nums, int target) {

        // 优化 二分查找 有序数组
        int l = 0, r = nums.length - 1;
        int res = nums.length;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target <= nums[mid]) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new Demo35().searchInsert(new int[]{1, 3, 5, 6}, 5));
//        System.out.println(new Demo35().searchInsert2(new int[]{1, 3, 5, 6}, 2));
        System.out.println(new Demo35().searchInsert2(new int[]{1, 3, 5, 6}, 7));
    }
}