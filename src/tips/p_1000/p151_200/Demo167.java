package tips.p_1000.p151_200;

/**
 * 给定一个已按照 升序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，
 * 所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 * 示例 2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * <p>
 * 示例 3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 *
 * @author hc
 */
public class Demo167 {

    public int[] twoSum(int[] numbers, int target) {
        /**
         * 1、双重遍历 O(n^2)
         */

        /**
         * 2、有序 -> 二分搜索 O(nlogn)
         */
        for (int i = 0; i < numbers.length; i++) {
            int l = i + 1, r = numbers.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] < target - numbers[i]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }


        /**
         * 3、对撞指针 O(n)
         */
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                return new int[]{l + 1, r + 1};
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[]{-1, -1};
    }
}
