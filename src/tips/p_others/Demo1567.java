package tips.p_others;

/**
 * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 * 请你返回乘积为正数的最长子数组长度。
 * <p>示例  1：
 * 输入：nums = [1,-2,-3,4]
 * 输出：4
 * 解释：数组本身乘积就是正数，值为 24 。
 * <p>示例 2：
 * 输入：nums = [0,1,-2,-3,-4]
 * 输出：3
 * 解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
 * 注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
 * <p>示例 3：
 * 输入：nums = [-1,-2,-3,0,1]
 * 输出：2
 * 解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
 * <p>示例 4：
 * 输入：nums = [-1,2]
 * 输出：1
 * <p>示例 5：
 * 输入：nums = [1,2,3,5,-6,4,0,10]
 * 输出：4
 * <p>提示：
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 *
 * @author hc
 */
public class Demo1567 {

    public int getMaxLen(int[] nums) {
        // 双指针 滑动窗口
        // 左边界指针 l 和右边界指针 r，初始值均为0
        // countL 和 countR 分别记录左指针和右指针左边的负数个数，初始值均为0
        int res = 0, len = nums.length;
        int r = 0;
        int countL = 0, countR = 0;
        for (int l = 0; l < len; l++) {
            if (nums[l] == 0) {
                r = l + 1;
                countL = countR = 0;
                continue;
            }
            while (r < len && nums[r] != 0) {
                if (nums[r] < 0) {
                    if (countR % 2 == 0) {
                        res = Math.max(res, r - l);
                    }
                    ++countR;
                } else if (countR % 2 == 0) {
                    res = Math.max(res, r - l);
                }
                ++r;
            }
            if ((countR - countL) % 2 == 0) {
                res = Math.max(res, r - l);
            }
            if (nums[l] < 0) {
                ++countL;
            }
        }
        return res;
    }

    public int getMaxLen2(int[] nums) {
        int res = 0;
        int p = 0, n = 0;
        for (int num : nums) {
            if (num == 0) {
                p = n = 0;
            } else if (num > 0) {
                ++p;
                if (n > 0) {
                    ++n;
                }
                res = Math.max(res, p);
            } else {
                int tem = p;
                p = n;
                n = tem;
                ++n;
                if (p > 0) {
                    ++p;
                }
                res = Math.max(res, p);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo1567().getMaxLen(new int[]{1, -2, -3, 4}));
        System.out.println(new Demo1567().getMaxLen(new int[]{0, 1, -2, -3, -4}));
        System.out.println(new Demo1567().getMaxLen(new int[]{-1, -2, -3, 0, 1}));
        System.out.println(new Demo1567().getMaxLen(new int[]{1, 2, 3, 5, -6, 4, 0, 10}));
    }
}
