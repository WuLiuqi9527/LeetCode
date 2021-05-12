package tips.p_1000.p301_350;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，
 * 将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 * <p>示例 1：
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * <p>示例 2：
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 * <p>提示：
 * 1 <= nums.length <= 5 * 10^4
 * 0 <= nums[i] <= 5000
 * 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
 * <p>参考：https://leetcode-cn.com/problems/wiggle-sort-ii/solution/yi-bu-yi-bu-jiang-shi-jian-fu-za-du-cong-onlognjia/
 *
 * @author hc
 */
public class Demo324 {

    /**
     * 排序 中间数 两个数组 A【小于】、B【大于】 穿插
     * 时间复杂度 O(NlogN) 空间复杂度 O(N)
     * 分数组反序 -> 解决 r【在A,B均重复,是 A的最大值, B的最小值】 个数等于 (len + 1)/2 的问题
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int midIndex = (len + 1) >> 1;
        int[] small = new int[midIndex];
        int[] large = new int[len - midIndex];
        for (int i = 0; i < len; i++) {
            if (i < midIndex) {
                small[i] = nums[i];
            } else {
                large[i - midIndex] = nums[i];
            }
        }

        // 应对 r 重复, A,B 数组反序
        reverse(small);
        reverse(large);
        // 分数组 穿插 回原数组
        boolean diff = true;
        int a = 0, b = 0;
        for (int i = 0; i < len; i++) {
            if (diff) {
                nums[i] = small[a++];
            } else {
                nums[i] = large[b++];
            }
            diff = !diff;
        }
    }

    private void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int tem = nums[left];
            nums[left] = nums[right];
            nums[right] = tem;
            ++left;
            --right;
        }
    }

    /**
     * 空间换时间
     */
    public void wiggleSort2(int[] nums) {
        // count sort
        int[] cnt = new int[5001];
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }
        int len = nums.length;
        int mid = (len - 1) >> 1;
        // index mapping
        int index = len - 1;
        for (int i = 5000; i >= 0; i--) {
            if (cnt[i] == 0) {
                continue;
            }
            while (cnt[i] != 0) {
                if (index <= mid) {
                    nums[2 * (mid - index)] = i;
                } else {
                    nums[1 + 2 * (len - 1 - index)] = i;
                }
                index--;
                cnt[i]--;
            }
        }
    }

    public static void main(String[] args) {
        new Demo324().wiggleSort(new int[]{1, 5, 2, 4, 3});
    }
}
