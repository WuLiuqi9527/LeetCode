package p701_750;

/**
 * 给你一个整数数组 nums，请编写一个能够返回数组 “中心下标” 的方法。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和 等于 右侧所有元素相加的和。
 * 如果数组不存在中心下标，返回 -1 。如果数组有多个中心下标，应该返回最靠近左边的那一个。
 * 注意：中心下标可能出现在数组的两端。
 * <p>示例 1：
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 (1 + 7 + 3 = 11)，
 * 右侧数之和 (5 + 6 = 11) ，二者相等。
 * <p>示例 2：
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 * <p>示例 3：
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 中心下标是 0 。
 * 下标 0 左侧不存在元素，视作和为 0 ；
 * 右侧数之和为 1 + (-1) = 0 ，二者相等。
 * <p>提示：
 * nums 的长度范围为 [0, 10000]。
 * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 *
 * @author hc
 */
public class Demo724 {

    public int pivotIndex(int[] nums) {

        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int leftNum = 0;
        for (int i = 0; i < len; i++) {
            // 以我为界，自我向左 等于 自我向右 唯我不在其中
            if (leftNum == sum - nums[i] - leftNum) {
                return i;
            }
            leftNum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Demo724().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(new Demo724().pivotIndex(new int[]{1, 2, 3}));
        System.out.println(new Demo724().pivotIndex(new int[]{2, 1, -1}));
    }
}
