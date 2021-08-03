package tips.p_1000.p551_600;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，
 * 如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * <p>示例 1：
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * <p>示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * <p>示例 3：
 * 输入：nums = [1]
 * 输出：0
 * <p>提示：
 * 1 <= nums.length <= 10^4
 * -10^5 <= nums[i] <= 10^5
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 *
 * @author hc
 */
public class Demo581 {

    public int findUnsortedSubarray(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int l = nums.length - 1, r = 0;
        int samCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (arr[i] != nums[i]) {
                l = Math.min(l, i);
                r = Math.max(r, i);
            } else {
                ++samCount;
            }
        }
        if (samCount == nums.length) {
            return 0;
        }
        return r - l + 1;
    }

    public int findUnsortedSubarray2(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        }
        int[] arr = nums.clone();
        Arrays.sort(arr);

        int l = 0;
        while (nums[l] == arr[l]) {
            l++;
        }
        int r = nums.length - 1;
        while (nums[r] == arr[r]) {
            r--;
        }
        return r - l + 1;
    }

    public boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }
}
