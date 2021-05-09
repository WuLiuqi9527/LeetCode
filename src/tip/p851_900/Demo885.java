package tip.p851_900;

/**
 * 在 R 行 C 列的矩阵上，我们从 (r0, c0) 面朝东面开始
 * 这里，网格的西北角位于第一行第一列，网格的东南角位于最后一行最后一列。
 * 现在，我们以顺时针按螺旋状行走，访问此网格中的每个位置。
 * 每当我们移动到网格的边界之外时，我们会继续在网格之外行走（但稍后可能会返回到网格边界）。
 * 最终，我们到过网格的所有 R * C 个空间。
 * 按照访问顺序返回表示网格位置的坐标列表。
 *
 * @author hc
 */
public class Demo885 {

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {

        int total = R * C;
        int[][] res = new int[total][];
        res[0] = new int[]{r0, c0};
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int count = 1;
        for (int i = 0; count < total; i++) {
            for (int j = 0; j < (i >> 1) + 1; j++) {
                r0 += dir[i % 4][0];
                c0 += dir[i % 4][1];
                if (0 <= r0 && r0 < R && 0 <= c0 && c0 < C) {
                    res[count++] = new int[]{r0, c0};
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new Demo885().spiralMatrixIII(5, 6, 1, 4);
    }
}
