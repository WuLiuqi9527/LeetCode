package tip.p51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 *
 * @author hc
 */
public class Demo52 {

    List<List<String>> res;

    public int totalNQueens(int n) {

        res = new ArrayList<>();
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }

        solve(res, chess, 0);
        return res.size();
    }

    private void solve(List<List<String>> res, char[][] chess, int row) {

        if (row == chess.length) {

            List<String> path = new ArrayList<>();
            for (int i = 0; i < chess.length; i++) {
                path.add(new String(chess[i]));
            }
            res.add(new ArrayList<>(path));
            return;
        }

        for (int col = 0; col < chess[0].length; col++) {
            if (valid(chess, row, col)) {
                chess[row][col] = 'Q';
                solve(res, chess, row + 1);
                chess[row][col] = '.';
            }
        }
    }

    private boolean valid(char[][] chess, int row, int col) {

        /* 上面 */
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        /* 右上角 */
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess[0].length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        /* 左上角 */
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
