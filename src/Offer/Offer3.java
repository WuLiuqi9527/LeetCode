package Offer;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * <p>示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>限制：
 * 2 <= n <= 100000
 *
 * @author hc
 */
public class Offer3 {

    /**
     * 空间复杂度 O(n) 时间复杂度 O(n)
     */
    public int findRepeatNumber(int[] nums) {
        // 边界条件
        int len = nums.length;
        if (len <= 1) {
            return Integer.MAX_VALUE;
        }

        int[] freq = new int[len];
        for (int num : nums) {
            ++freq[num];
        }

        for (int i = 0; i < len; i++) {
            if (freq[i] > 1) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }

//    public int findRepeatNumber2(int[] nums) {
//
//    }

    public static void main(String[] args) {
        System.out.println(new Offer3().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
