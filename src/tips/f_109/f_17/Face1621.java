package tips.f_109.f_17;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。
 * 若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 * <p>示例:
 * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 * 输出: [1, 3]
 * <p>示例:
 * 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
 * 输出: []
 * <p>提示：
 * 1 <= array1.length, array2.length <= 100000
 *
 * @author hc
 */
public class Face1621 {

    public int[] findSwapValues(int[] array1, int[] array2) {

        int sum1 = 0, sum2 = 0;
        for (int arr : array1) {
            sum1 += arr;
        }
        for (int arr : array2) {
            sum2 += arr;
        }

        // target = a - b = (sumA - sumB) / 2
        if (((sum1 - sum2) & 1) == 1) {
            return new int[0];
        }

        int target = (sum1 - sum2) >> 1;
        Set<Integer> set = new HashSet<>();
        for (int arr1 : array1) {
            set.add(arr1 - target);
        }
        for (int arr2 : array2) {
            if (set.contains(arr2)) {
                return new int[]{arr2 + target, arr2};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        new Face1621().findSwapValues(new int[]{4, 1, 2, 1, 1, 2}, new int[]{3, 6, 3, 3});
        new Face1621().findSwapValues(new int[]{1, 2, 3}, new int[]{4, 5, 6});
    }
}
