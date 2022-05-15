package tips.p_1000.p801_850;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 * <p>示例:
 * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出: 2
 * 解释:
 * 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
 * <p>注意:
 * 3 <= points.length <= 50.
 * 不存在重复的点。
 * -50 <= points[i][j] <= 50.
 * 结果误差值在 10^-6 以内都认为是正确答案。
 *
 * @author hc
 */
public class Demo812 {

    public static double largestTriangleArea(int[][] points) {
        int len = points.length;
        double res = 0;
        for (int i = 0; i < len; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < len; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                for (int k = j + 1; k < len; k++) {
                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    res = Math.max(res, area(x1, y1, x2, y2, x3, y3));
                }
            }
        }
        return res;
    }

    private static double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
    }

    public static void main(String[] args) {
        System.out.println(largestTriangleArea(new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}}));
    }
}
