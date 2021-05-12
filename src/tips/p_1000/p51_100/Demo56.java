package tips.p_1000.p51_100;

import java.util.*;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * @author hc
 */
public class Demo56 {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {

            int l = interval[0], r = interval[1];

            if (res.size() == 0 || res.get(res.size() - 1)[1] < l) {
                res.add(new int[]{l, r});
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], r);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        new Demo56().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
}
