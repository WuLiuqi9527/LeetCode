package tips.f_109.f_17;

/**
 * 给定两个正方形及一个二维平面。请找出将这两个正方形分割成两半的一条直线。假设正方形顶边和底边与 x 轴平行。
 * 每个正方形的数据square包含3个数值，正方形的左下顶点坐标[X,Y] = [square[0],square[1]]，以及正方形的边长square[2]。
 * 所求直线穿过两个正方形会形成4个交点，请返回4个交点形成线段的两端点坐标（两个端点即为4个交点中距离最远的2个点，
 * 这 2个点所连成的线段一定会穿过另外2个交点）。
 * 2个端点坐标 [X1,Y1]和 [X2,Y2]的返回格式为 {X1,Y1,X2,Y2}，要求若 X1 != X2，需保证 X1 < X2，否则需保证 Y1 <= Y2。
 * 若同时有多条直线满足要求，则选择斜率最大的一条计算并返回（与 Y轴平行的直线视为斜率无穷大）。
 * <p>示例：
 * 输入：
 * square1 = {-1, -1, 2}
 * square2 = {0, -1, 2}
 * 输出： {-1,0,2,0}
 * 解释： 直线 y = 0 能将两个正方形同时分为等面积的两部分，返回的两线段端点为[-1,0]和[2,0]
 * <p>提示：
 * square.length == 3
 * square[2] > 0
 *
 * @author hc
 */
public class Face1613 {

    public double[] cutSquares(int[] square1, int[] square2) {
        double[] res = new double[4];

        int x1 = square1[0], y1 = square1[1], l1 = square1[2];
        int x2 = square2[0], y2 = square2[1], l2 = square2[2];

        // 正方形中点
        double[] center1 = new double[]{x1 + l1 / 2.0, y1 + l1 / 2.0};
        double[] center2 = new double[]{x2 + l2 / 2.0, y2 + l2 / 2.0};

        // 重点重合
        if (center1[0] == center2[0]) {
            res[0] = center1[0];
            res[1] = Math.min(y1, y2);
            res[2] = center2[0];
            res[3] = Math.max(y1 + l1, y2 + l2);
            return res;
        }

        double k = (center1[1] - center2[1]) / (center1[0] - center2[0]);
        // 斜率 k < 1 分割线与左右边相交, 否则与上下边相交
        if (Math.abs(k) < 1) {
            res[0] = Math.min(x1, x2);
            res[1] = center1[1] - k * (center1[0] - res[0]);
            res[2] = Math.max(x1 + l1, x2 + l2);
            res[3] = center2[1] - k * (center2[0] - res[2]);
            return res;
        } else {
            res[1] = Math.min(y1, y2);
            res[3] = Math.max(y1 + l1, y2 + l2);
            res[0] = center1[0] - (center1[1] - res[1]) / k;
            res[2] = center2[0] - (center2[1] - res[3]) / k;
            return res[0] < res[2] ? new double[]{res[0], res[1], res[2], res[3]} :
                    new double[]{res[2], res[3], res[0], res[1]};
        }
    }
}
