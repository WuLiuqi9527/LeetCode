package tip.o1_50;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * <p>示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * <p>提示：
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 *
 * @author hc
 */
public class Offer12 {

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, int k) {
        if (k >= word.length()) {
            return true;
        }

        boolean unreasonable = i < 0 || i >= board.length || j < 0 || j >= board[0].length;
        if (unreasonable || board[i][j] != word.charAt(k)) {
            return false;
        }

        board[i][j] += 256;
        boolean res = search(board, word, i + 1, j, k + 1)
                || search(board, word, i - 1, j, k + 1)
                || search(board, word, i, j + 1, k + 1)
                || search(board, word, i, j - 1, k + 1);
        board[i][j] -= 256;

        return res;
    }
}
