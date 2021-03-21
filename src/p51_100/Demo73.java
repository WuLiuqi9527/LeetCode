package p51_100;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * <p>
 * 示例 1:
 * 输入:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 *
 * @author hc
 */
public class Demo73 {

    public void setZeroes(int[][] matrix) {

        int cowLen = matrix.length;
        int rolLen = matrix[0].length;
        boolean cow = false, rol = false;

        for (int i = 0; i < cowLen; i++) {
            for (int j = 0; j < rolLen; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        cow = true;
                    }
                    if (j == 0) {
                        rol = true;
                    }
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < cowLen; i++) {
            for (int j = 1; j < rolLen; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (cow) {
            for (int j = 0; j < rolLen; j++) {
                matrix[0][j] = 0;
            }
        }

        if (rol) {
            for (int i = 0; i < cowLen; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        new Demo73().setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
    }
}
