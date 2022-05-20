package tips.p_1000.p401_450;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
 * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
 * 返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。
 * 如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
 * <p>示例 1：
 * 输入：intervals = [[1,2]]
 * 输出：[-1]
 * 解释：集合中只有一个区间，所以输出-1。
 * <p>示例 2：
 * 输入：intervals = [[3,4],[2,3],[1,2]]
 * 输出：[-1,0,1]
 * 解释：对于 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间[3,4]具有最小的“右”起点;
 * 对于 [1,2] ，区间[2,3]具有最小的“右”起点。
 * <p>示例 3：
 * 输入：intervals = [[1,4],[2,3],[3,4]]
 * 输出：[-1,2,-1]
 * 解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
 * <p>提示：
 * 1 <= intervals.length <= 2 * 10^4
 * intervals[i].length == 2
 * -10^6 <= starti <= endi <= 10^6
 * 每个间隔的起点都 不相同
 *
 * @author hc
 */
public class Demo436 {

    public static int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        int[][] data = new int[len][3];
        for (int i = 0; i < len; i++) {
            data[i][0] = intervals[i][0];
            data[i][1] = intervals[i][1];
            data[i][2] = i;
        }
        Arrays.sort(data, Comparator.comparingInt(o -> o[0]));
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int index = 0;
            for (int j = 0; j < len; j++) {
                if (data[j][0] >= intervals[i][1]) {
                    index = j;
                    break;//找到第一个左端点比intervals[i]右端点大的索引
                }
            }
            res[i] = data[index][0] >= intervals[i][1] ? data[index][2] : -1;
        }
        return res;
    }

    public static int[] findRightInterval2(int[][] intervals) {
        int len = intervals.length;
        int[][] data = new int[len][2];
        for (int i = 0; i < len; i++) {
            data[i][0] = intervals[i][0];
            data[i][1] = i;
        }
        Arrays.sort(data, Comparator.comparingInt(o -> o[0]));
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            //二分查找优化
            int l = 0, r = len - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (data[mid][0] >= intervals[i][1]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            res[i] = data[r][0] >= intervals[i][1] ? data[r][1] : -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}});
        for (int r : res) {
            System.out.print(r + "\t");
        }
    }
}
