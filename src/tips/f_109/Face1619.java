package tips.f_109;

import java.util.ArrayList;
import java.util.List;

/**
 * 你有一个用于表示一片土地的整数矩阵 land，该矩阵中每个点的值代表对应地点的海拔高度。
 * 若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。
 * 编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * <p>示例：
 * 输入：
 * [
 * [0,2,1,0],
 * [0,1,0,1],
 * [1,1,0,1],
 * [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 * <p>提示：
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 *
 * @author hc
 */
public class Face1619 {

    /** 与 p200-岛屿数量 相同 */
    public int[] pondSizes(int[][] land) {
        int row = land.length, col = land[0].length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (land[i][j] == 0) {
                    int landNum = infect(land, i, j);
                    res.add(landNum);
                }
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private int infect(int[][] land, int i, int j) {
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] != 0) {
            return 0;
        }

        int landNum = 1;
        land[i][j] = -1;

        landNum += infect(land, i + 1, j);
        landNum += infect(land, i - 1, j);
        landNum += infect(land, i, j + 1);
        landNum += infect(land, i, j - 1);
        landNum += infect(land, i + 1, j + 1);
        landNum += infect(land, i - 1, j - 1);
        landNum += infect(land, i + 1, j - 1);
        landNum += infect(land, i - 1, j + 1);

        return landNum;
    }

    public static void main(String[] args) {
        new Face1619().pondSizes(new int[][]{{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}});
    }
}
