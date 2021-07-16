package tips.o_68.o51_68;

/**
 * 统计一个数字在排序数组中出现的次数。
 * <p>示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * <p>示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>限制：
 * 0 <= 数组长度 <= 50000
 *
 * @author hc
 */
public class Offer53One {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int count = 0;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        while (l < nums.length && nums[l++] == target) {
            ++count;
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(new Offer53One().search(new int[]{1}, 1));
        System.out.println(new Offer53One().search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(new Offer53One().search(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }
}
