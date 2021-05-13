package tips.f_109;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * <p>示例 1：
 * 输入：
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出：
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 *
 * @author hc
 */
public class Face0108 {
    /**
     * 拿第一行和第一列 来作为 该行该列的标志位
     */
    public void setZeroes(int[][] matrix) {
        int cow = matrix.length;
        int rol = matrix[0].length;
        // 记录第一行，第一列是否有 0
        boolean isCow = false, isRol = false;

        for (int i = 0; i < cow; i++) {
            for (int j = 0; j < rol; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        isCow = true;
                    }
                    if (j == 0) {
                        isRol = true;
                    }
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < cow; i++) {
            for (int j = 1; j < rol; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isCow) {
            for (int i = 0; i < rol; i++) {
                matrix[0][i] = 0;
            }
        }
        if (isRol) {
            for (int i = 0; i < cow; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
