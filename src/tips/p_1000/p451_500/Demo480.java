package tips.p_1000.p451_500;

import java.util.Arrays;

/**
 * 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 * 例如：
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。
 * 你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 * <p>示例：
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * 1 [3  -1  -3] 5  3  6  7      -1
 * 1  3 [-1  -3  5] 3  6  7      -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 * 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 * <p>提示：
 * 你可以假设 k 始终有效，即：k 始终小于等于输入的非空数组的元素个数。
 * 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
 *
 * @author hc
 */
public class Demo480 {

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int[] windows = new int[k];
        System.arraycopy(nums, 0, windows, 0, k);
        Arrays.sort(windows);
        res[0] = getMid(windows);
        for (int i = 0; i < nums.length - k; i++) {
            int index = search(windows, nums[i]);
            windows[index] = nums[i + k];
            Arrays.sort(windows);
            res[i + 1] = getMid(windows);
        }
        return res;
    }

    private int search(int[] windows, int target) {
        int l = 0, r = windows.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (windows[mid] > target) {
                r = mid - 1;
            } else if (windows[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private double getMid(int[] windows) {
        int len = windows.length;
        if ((len & 1) == 0) {
            return windows[len >> 1] / 2.0 + windows[(len >> 1) - 1] / 2.0;
        } else {
            return windows[len >> 1];
        }
    }

    public static void main(String[] args) {
        new Demo480().medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        new Demo480().medianSlidingWindow(new int[]{1, 4, 2, 3}, 4);
    }
}
