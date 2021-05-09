package tip.p1_50;

/**
 * 编写一个程序，通过填充空格来解决数独问题。
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 * @author hc
 */
public class Demo37 {

    public void solveSudoku(char[][] board) {

        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }

        // 行是否重复
        boolean[][] row = new boolean[9][9];
        // 列是否重复
        boolean[][] col = new boolean[9][9];
        // 小九格是否重复
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int k = (i / 3) * 3 + j / 3;
                    row[i][num] = col[j][num] = box[k][num] = true;
                }
            }
        }
        solveSudokuHelper(board, 0, row, col, box);
    }

    boolean solveSudokuHelper(char[][] board, int n, boolean[][] row, boolean[][] col, boolean[][] box) {
        if (n == 81) {
            return true;
        }

        int i = n / 9, j = n % 9;
        if (board[i][j] != '.') {
            return solveSudokuHelper(board, n + 1, row, col, box);
        }

        int k = (i / 3) * 3 + j / 3;
        for (int num = 0; num < 9; num++) {
            if (row[i][num] || col[j][num] || box[k][num]) {
                continue;
            }

            board[i][j] = (char) (num + '1');

            row[i][num] = col[j][num] = box[k][num] = true;
            if (solveSudokuHelper(board, n + 1, row, col, box)) {
                return true;
            }
            row[i][num] = col[j][num] = box[k][num] = false;
        }

        board[i][j] = '.';
        return false;
    }
}
