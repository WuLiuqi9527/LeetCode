package tip.lt1000.p351_400;

import java.util.Arrays;

/**
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 说明:
 * 不允许旋转信封。
 * <p>
 * 示例:
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * @author hc
 */
public class Demo354 {

    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        int maxL = 0;
        int[] dp = new int[envelopes.length];
        for (int[] env : envelopes) {
            int low = 0, high = maxL;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (dp[mid] < env[1]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            dp[low] = env[1];
            if (low == maxL) {
                maxL++;
            }
        }
        return maxL;
    }


    public static void main(String[] args) {

        System.out.println(new Demo354().maxEnvelopes(new int[][]{{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}}));
    }
}
