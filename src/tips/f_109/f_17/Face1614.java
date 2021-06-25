package tips.f_109.f_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个二维平面及平面上的 N 个点列表Points，其中第i个点的坐标为Points[i]=[Xi,Yi]。
 * 请找出一条直线，其通过的点的数目最多。
 * 设穿过最多点的直线所穿过的全部点编号从小到大排序的列表为S，你仅需返回[S[0],S[1]]作为答案，
 * 若有多条直线穿过了相同数量的点，则选择S[0]值较小的直线返回，S[0]相同则选择S[1]值较小的直线返回。
 * <p>示例：
 * 输入： [[0,0],[1,1],[1,0],[2,0]]
 * 输出： [0,2]
 * 解释： 所求直线穿过的3个点的编号为[0,2,3]
 * <p>提示：
 * 2 <= len(Points) <= 300
 * len(Points[i]) = 2
 *
 * @author hc
 */
public class Face1614 {

    public int[] bestLine(int[][] points) {
        int n = points.length;
        List<Map<Double, Integer>> dp = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            dp.add(new HashMap<>());
        }
        int maxCnt = 0, l = 0, r = 0;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                int dx = points[i][0] - points[j][0], dy = points[i][1] - points[j][1];
                double k = dx == 0 ? Double.POSITIVE_INFINITY : dy == 0 ? 0 : (double) dy / dx;
                int cnt = dp.get(j).getOrDefault(k, 1) + 1;
                dp.get(i).put(k, cnt);
                if (maxCnt > cnt) {
                    continue;
                }
                maxCnt = cnt;
                l = i;
                r = j;
            }
        }
        return new int[]{l, r};
    }
}
