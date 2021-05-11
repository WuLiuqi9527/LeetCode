package tip.lt1000.p51_100;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * @author hc
 */
public class Demo59 {

    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];

        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int count = 0;
        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {
                res[top][i] = ++count;
            }

            for (int i = top+1; i <= bottom; i++) {
                res[i][right] = ++count;
            }

            if (left < right && top < bottom) {
                for (int i = right-1; i >= left ; --i) {
                    res[bottom][i]  = ++count;
                }

                for (int i = bottom-1; i > top; --i) {
                    res[i][left] = ++count;
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
        new Demo59().generateMatrix(3);
    }
}
