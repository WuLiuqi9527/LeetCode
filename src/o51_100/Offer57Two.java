package o51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * <p>示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>限制：
 * 1 <= target <= 10^5
 *
 * @author hc
 */
public class Offer57Two {

    public int[][] findContinuousSequence(int target) {
        // 滑动窗口
        List<int[]> lists = new ArrayList<>();

        int limit = (target >> 1) + 1;
        for (int l = 1, r = 1, sum = 0; r <= limit; ++r) {
            sum += r;
            while (sum > target) {
                // 缩减左边窗口
                sum -= l;
                ++l;
            }
            if (sum == target) {
                int[] list = new int[r - l + 1];
                for (int i = 0; i < list.length; i++) {
                    list[i] = l + i;
                }
                lists.add(list);
            }
        }

        int[][] res = new int[lists.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = lists.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        new Offer57Two().findContinuousSequence(15);
    }
}
