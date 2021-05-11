package tip.lt1000.p51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，
 * 请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 * @author hc
 */
public class Demo54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        int top = 0, left = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }

            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }

            // 添加时边界不能取等号
            if (left < right && top < bottom) {
                for (int i = right - 1; i >= left; --i) {
                    res.add(matrix[bottom][i]);
                }

                for (int i = bottom - 1; i > top; --i) {
                    res.add(matrix[i][left]);
                }
            }
            ++top;
            ++left;
            --bottom;
            --right;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo54().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(new Demo54().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
