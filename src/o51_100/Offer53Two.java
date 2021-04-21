package o51_100;

/**
 * 一个长度为 n-1 的 递增 排序数组中的所有数字都是 唯一 的，并且每个数字都在范围 0～n-1 之内。
 * 在范围 0～n-1 内的 n 个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * <p>示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * <p>限制：
 * 1 <= 数组长度 <= 10000
 *
 * @author hc
 */
public class Offer53Two {

    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] != mid) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
