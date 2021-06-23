package tips.f_109;

/**
 * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，
 * 由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
 * 以下是井字游戏的规则：
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
 * "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 * <p>示例 1：
 * 输入： board = ["O X"," XO","X O"]
 * 输出： "X"
 * <p>示例 2：
 * 输入： board = ["OOX","XXO","OXO"]
 * 输出： "Draw"
 * 解释： 没有玩家获胜且不存在空位
 * <p>示例 3：
 * 输入： board = ["OOX","XXO","OX "]
 * 输出： "Pending"
 * 解释： 没有玩家获胜且仍存在空位
 * <p>提示：
 * 1 <= board.length == board[i].length <= 100
 * 输入一定遵循井字棋规则
 *
 * @author hc
 */
public class Face1604 {

    public String tictactoe(String[] board) {

        int N = board.length;
        int row, col, leadDiag = 0, counterDiag = 0;
        // 是否有空格
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            row = 0;
            col = 0;
            leadDiag += board[i].charAt(i);
            counterDiag += board[i].charAt(N - 1 - i);
            for (int j = 0; j < N; j++) {
                row += board[i].charAt(j);
                col += board[j].charAt(i);
                if (board[i].charAt(j) == ' ') {
                    flag = true;
                }
            }

            if (row == 'X' * N || col == 'X' * N) {
                return "X";
            } else if (row == 'O' * N || col == 'O' * N) {
                return "O";
            }
        }

        if (leadDiag == 'X' * N || counterDiag == 'X' * N) {
            return "X";
        } else if (leadDiag == 'O' * N || counterDiag == 'O' * N) {
            return "O";
        }

        if (flag) {
            return "Pending";
        }

        return "Draw";
    }
}
