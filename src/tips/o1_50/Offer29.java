package tips.o1_50;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 *
 * @author hc
 */
public class Offer29 {

    public int[] spiralOrder(int[][] matrix) {

        if (matrix.length == 0) {
            return new int[0];
        }

        int top = 0, left = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            for (int i = top + 1; i <= bottom; i++) {
                res[index++] = matrix[i][right];
            }

            if (left < right && top < bottom) {
                for (int i = right - 1; i >= left; --i) {
                    res[index++] = matrix[bottom][i];
                }
                for (int i = bottom - 1; i > top; --i) {
                    res[index++] = matrix[i][left];
                }
            }

            ++left;
            ++top;
            --right;
            --bottom;
        }
        return res;
    }

    public static void main(String[] args) {
        new Offer29().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
    }
}
