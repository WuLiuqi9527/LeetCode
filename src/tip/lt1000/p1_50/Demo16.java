package tip.lt1000.p1_50;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 * <p>
 * 示例：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * 提示：
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * @author hc
 */
public class Demo16 {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int len = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < len - 2; ++i) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int L = i + 1, R = len - 1;
            while (L < R) {
                int threeSum = nums[i] + nums[L] + nums[R];
                if (Math.abs(threeSum - target) < Math.abs(closestSum - target)) {
                    closestSum = threeSum;
                }
                if (threeSum < target){
                    L++;
                }else if (threeSum> target){
                    R--;
                }else {
                    return target;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        System.out.println(new Demo16().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
