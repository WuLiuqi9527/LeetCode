package tip.p51_100;

import java.util.ArrayList;

/**
 * 给你一个 无重叠的 ，按照区间 起始端点 排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 *
 * @author hc
 */
public class Demo57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        for (; i < intervals.length; i++) {
            int l = intervals[i][0], r = intervals[i][1];
            if (newInterval[1] < l) {
                break;
            } else if (newInterval[0] > r) {
                res.add(intervals[i]);
            } else { // 有重叠
                newInterval[0] = Math.min(newInterval[0], l);
                newInterval[1] = Math.max(newInterval[1], r);
            }
        }

        res.add(newInterval);
        while (i < intervals.length) {
            res.add(intervals[i++]);
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        new Demo57().insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
    }
}
