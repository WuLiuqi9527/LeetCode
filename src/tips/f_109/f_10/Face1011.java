package tips.f_109.f_10;

import java.util.Arrays;

/**
 * 在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。
 * 例如，在数组{5, 8, 4, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。
 * 现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
 * <p>示例:
 * 输入: [5, 3, 1, 2, 3]
 * 输出: [5, 1, 3, 2, 3]
 * <p>提示：
 * nums.length <= 10000
 *
 * @author hc
 */
public class Face1011 {

    public void wiggleSort(int[] nums) {
        if (nums.length <= 2) {
            return;
        }
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i < len; i += 2) {
            nums[i] = nums[i] ^ nums[i - 1];
            nums[i - 1] = nums[i] ^ nums[i - 1];
            nums[i] = nums[i] ^ nums[i - 1];
        }
    }

    public void wiggleSort2(int[] nums) {
        if (nums.length <= 2) {
            return;
        }
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            boolean isReverse = (i & 1) == 0 && nums[i] < nums[i - 1] ||
                    (i & 1) == 1 && nums[i] > nums[i - 1];
            if (isReverse) {
                nums[i] = nums[i] ^ nums[i - 1];
                nums[i - 1] = nums[i] ^ nums[i - 1];
                nums[i] = nums[i] ^ nums[i - 1];
            }
        }
    }
}
