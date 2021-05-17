package tips.f_109;

import java.util.Arrays;

/**
 * 堆箱子。给你一堆n个箱子，箱子宽 wi、深 di、高 hi。
 * 箱子不能翻转，将箱子堆起来时，下面箱子的宽度、高度和深度必须大于上面的箱子。
 * 实现一种方法，搭出最高的一堆箱子。箱堆的高度为每个箱子高度的总和。
 * 输入使用数组[wi, di, hi]表示每个箱子。
 * <p>示例1:
 * 输入：box = [[1, 1, 1], [2, 2, 2], [3, 3, 3]]
 * 输出：6
 * <p>示例2:
 * 输入：box = [[1, 1, 1], [2, 3, 4], [2, 6, 7], [3, 4, 5]]
 * 输出：10
 * <p>提示:
 * 箱子的数目不大于3000个。
 *
 * @author hc
 */
public class Face0813 {

    public int pileBox(int[][] box) {
        int len = box.length;
        if (len == 0) {
            return 0;
        }
        Arrays.sort(box, (o1, o2) -> o1[0] - o2[0]);
        int[] dp = new int[len];
        int res = 0;
        for (int i = 0; i < len; i++) {
            dp[i] = box[i][2];
            for (int j = 0; j < i; j++) {
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + box[i][2]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
