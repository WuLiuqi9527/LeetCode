package tips.f_109;

/**
 * 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 * <p>示例:
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 *
 * @author hc
 */
public class Face1009 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length <= 0) {
            return false;
        }
        // 暴力
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length <= 0) {
            return false;
        }
        // 利用 有序
        int row = matrix.length - 1, col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                --row;
            }else if (matrix[row][col] < target) {
                ++col;
            }else {
                return true;
            }
        }
        return false;
    }
}
