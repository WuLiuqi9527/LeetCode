package tips.p_1000.p751_800;

import java.util.*;

/**
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 * <p>示例：
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 * 输入：board = [[3,2,4],[1,5,0]]
 * 输出：14
 * <p>提示：
 * board 是一个如上所述的 2 x 3 的数组.
 * board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
 *
 * @author hc
 */
public class Demo773 {

    private final int[][] neighbors = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        // BFS
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }

        String initial = sb.toString();
        if ("123450".equals(initial)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(initial);
        Set<String> visited = new HashSet<>();
        visited.add(initial);

        int step = 0;
        while (!queue.isEmpty()) {
            ++step;
            for (int i = queue.size(); i > 0; i--) {
                String status = queue.poll();
                for (String nextStatus : getNextStatus(status)) {
                    if (!visited.contains(nextStatus)) {
                        if ("123450".equals(nextStatus)) {
                            return step;
                        }
                        queue.add(nextStatus);
                        visited.add(nextStatus);
                    }
                }
            }
        }
        return -1;
    }

    private List<String> getNextStatus(String status) {
        List<String> res = new ArrayList<>();
        char[] arr = status.toCharArray();
        int index = status.indexOf('0');
        for (int n : neighbors[index]) {
            swap(arr, index, n);
            res.add(new String(arr));
            swap(arr, index, n);
        }
        return res;
    }

    private void swap(char[] arr, int i, int j) {
        char tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }
}
