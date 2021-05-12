package tips.p_1000.p51_100;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * <p>
 * 提示：
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * @author hc
 */
public class Demo79 {

    /**
     * 二维回溯
     */
    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
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

        // 使其超过 ASCII 码范围 -> 不被重复选择
        board[i][j] += 256;
        boolean res = search(board, word, i - 1, j, k + 1) || search(board, word, i + 1, j, k + 1) || search(board, word, i, j - 1, k + 1) || search(board, word, i, j - 1, k + 1);
        board[i][j] -= 256;

        return res;
    }
}
