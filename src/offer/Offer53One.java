package offer;

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
        if (nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) {
            return 0;
        }

        int res = 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                ++res;
                int front = mid - 1, last = mid + 1;
                while (front >= left && nums[front] == target) {
                    ++res;
                    --front;
                }
                while (last <= right && nums[last] == target) {
                    ++res;
                    ++last;
                }
                return res;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println(new Offer53One().search(new int[]{1}, 1));
        System.out.println(new Offer53One().search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(new Offer53One().search(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }
}
