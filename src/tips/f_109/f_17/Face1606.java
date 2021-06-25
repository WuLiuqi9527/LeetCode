package tips.f_109.f_17;

import java.util.Arrays;

/**
 * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 * <p>示例：
 * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 * 输出：3，即数值对(11, 8)
 * <p>提示：
 * 1 <= a.length, b.length <= 100000
 * -2147483648 <= a[i], b[i] <= 2147483647
 * 正确结果在区间 [0, 2147483647] 内
 *
 * @author hc
 */
public class Face1606 {

    public int smallestDifference(int[] a, int[] b) {
        // 暴力法 O(m * n) 超时
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                long sub = Math.abs((long) (a[i] - b[j]));
                res = (int) Math.min(res, sub);
            }
        }
        return res;
    }

    public int smallestDifference2(int[] a, int[] b) {
        // 排序
        Arrays.sort(a);
        Arrays.sort(b);
        int res = Integer.MAX_VALUE;
        int aIndex = 0, aLen = a.length, bIndex = 0, bLen = b.length;
        while (aIndex < aLen && bIndex < bLen) {
            long diff = a[aIndex] - b[bIndex];
            res = (int) Math.min(res, Math.abs(diff));
            if (diff < 0) {
                ++aIndex;
            } else {
                ++bIndex;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Face1606().smallestDifference(new int[]{-2147483648, 1}, new int[]{2147483647, 0}));
        System.out.println(new Face1606().smallestDifference(new int[]{1, 3, 15, 11, 2}, new int[]{23, 127, 235, 19, 8}));
    }
}
