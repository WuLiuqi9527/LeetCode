package tip.p1_50;

/**
 * 判断一个 9x9 的数独是否有效。
 * 只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * @author hc
 */
public class Demo36 {

    public boolean isValidSudoku(char[][] board) {

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
                    // (i, j) 位于 (i/3, j/3)的 九宫格中
                    // 其在当前九宫格中的位置索引为 (i/3) * 3 + (j/3)
                    // 假设 (7, 7) 是位于右下角 (2, 2)的九宫格中， 它在该九宫格中第二行第二列，则其索引 为 3+2 = 5
                    int k = (i / 3) * 3 + j / 3;

                    if (row[i][num] || col[j][num] || box[k][num]){
                        return false;
                    }else {
                        row[i][num] = col[j][num] = box[k][num] = true;
                    }
                }
            }
        }
        return true;
    }
}
