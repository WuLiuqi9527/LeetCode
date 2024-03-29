package tips.f_109.f_17;

import java.util.Arrays;

/**
 * 有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。
 * 出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。
 * 已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
 * <p>示例：
 * 输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
 * 输出：6
 * 解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
 * <p>提示：
 * height.length == weight.length <= 10000
 *
 * @author hc
 */
public class Face1708 {

    public int bestSeqAtIndex(int[] height, int[] weight) {
        // dp 超时
        int len = height.length;
        int[][] person = new int[len][2];
        for (int i = 0; i < len; ++i) {
            person[i] = new int[]{height[i], weight[i]};
        }

        Arrays.sort(person, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int[] dp = new int[len];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < len; ++i) {
            int max_val = 0, base_weight = person[i][1];
            for (int j = 0; j < i; ++j) {
                if (base_weight > person[j][1]) {
                    max_val = Math.max(max_val, dp[j]);
                }
            }
            dp[i] = max_val + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int bestSeqAtIndex2(int[] height, int[] weight) {
        // 二分查找
        int len = height.length;
        int[][] person = new int[len][2];
        for (int i = 0; i < len; ++i) {
            person[i] = new int[]{height[i], weight[i]};
        }
        Arrays.sort(person, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[len];
        int res = 0;
        for (int[] pair : person) {
            int i = Arrays.binarySearch(dp, 0, res, pair[1]);
            if (i < 0) {
                i = -(i + 1);
            }

            dp[i] = pair[1];

            if (i == res) {
                ++res;
            }
        }
        return res;
    }
}
