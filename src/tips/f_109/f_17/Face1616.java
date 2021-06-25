package tips.f_109.f_17;

/**
 * 给定一个整数数组，编写一个函数，找出索引 m 和 n，只要将索引区间 [m,n] 的元素排好序，整个数组就是有序的。
 * 注意：n-m 尽量最小，也就是说，找出符合条件的最短序列。函数返回值为 [m,n]，
 * 若不存在这样的 m 和 n（例如整个数组是有序的），请返回 [-1,-1]。
 * <p>示例：
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 * <p>提示：
 * 0 <= len(array) <= 1000000
 *
 * @author hc
 */
public class Face1616 {

    public int[] subSort(int[] array) {
        int len = array.length;
        int left = -1, right = -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        // 从前往后找目标末位，使得从该位到最后，数组保持递增
        for (int i = 0; i < len; i++) {
            if (array[i] >= max) {
                max = array[i];
            } else {
                right = i;
            }
        }

        // 数组恒递增，说明数组是有序的，直接返回
        if (right == -1) {
            return new int[]{-1, -1};
        }

        // 从后往前找目标首位，使得从该位到最前，数组保持递减
        for (int i = right; i >= 0; --i) {
            if (array[i] <= min) {
                min = array[i];
            } else {
                left = i;
            }
        }
        return new int[]{left, right};
    }
}
