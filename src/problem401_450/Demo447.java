package problem401_450;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。
 * 回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * 返回平面上所有回旋镖的数量。
 * <p>
 * 示例 1：
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * <p>
 * 示例 2：
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：points = [[1,1]]
 * 输出：0
 * <p>
 * 提示：
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * 所有点都 互不相同
 *
 * @author hc
 */
public class Demo447 {

    public int numberOfBoomerangs(int[][] points) {

        int res = 0;
        for (int[] pointOne : points) {
            // <距离， 频次>
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] pointTwo : points) {
                if (pointOne != pointTwo) {
                    int dis = distance(pointOne, pointTwo);
                    map.put(dis, map.getOrDefault(dis, 0) + 1);
                }
            }

            for (Integer integer : map.values()) {
                res += integer * (integer - 1);
            }
        }
        return res;
    }

    private int distance(int[] pointOne, int[] pointTwo) {
        return (pointOne[0] - pointTwo[0]) * (pointOne[0] - pointTwo[0]) + (pointOne[1] - pointTwo[1]) * (pointOne[1] - pointTwo[1]);
    }

    public static void main(String[] args) {
        System.out.println(new Demo447().numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
    }
}
