package tips.p_others;

/**
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。
 * 我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>示例 1：
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * <p>请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * <p>示例 2：
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * <p>示例 3：
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * <p>提示：
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 *
 * @author hc
 */
public class Demo1011 {

    public int shipWithinDays(int[] weights, int D) {

        // 模拟 逐渐 +1
        int minWeigh = 0, max = Integer.MIN_VALUE;
        for (int w : weights) {
            minWeigh += w;
            max = Math.max(max, w);
        }
        minWeigh = Math.max((int) Math.ceil(minWeigh / D), max);

        int sum = 0, time = 1;
        int lenW = weights.length;
        for (int i = minWeigh; ; ++i) {
            for (int j = 0; j < lenW; j++) {
                if (i - sum >= weights[j]) {
                    sum += weights[j];
                } else {
                    sum = weights[j];
                    ++time;
                }
            }
            if (time <= D) {
                return i;
            } else {
                sum = 0;
                time = 1;
            }
        }
    }

    public int shipWithinDays2(int[] weights, int D) {
        // 二分法
        int max = Integer.MIN_VALUE, sum = 0;
        for (int w : weights) {
            max = Math.max(max, w);
            sum += w;
        }
        // 理论最低运力：只确保所有包裹能够被运送, max 为数组 weights 中的最大值
        // 理论最高运力：使得所有包裹在最短时间（一天）内运算完成，sum 为数组 weights 的总和
        int l = max, r = sum;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (check(weights, mid, D)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private boolean check(int[] weights, int t, int D) {
        int n = weights.length;
        int cnt = 1;
        for (int i = 1, sum = weights[0]; i < n; sum = 0, cnt++) {
            while (i < n && sum + weights[i] <= t) {
                sum += weights[i];
                i++;
            }
        }
        return cnt - 1 <= D;
    }

    public static void main(String[] args) {
        System.out.println(new Demo1011().shipWithinDays2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(new Demo1011().shipWithinDays2(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println(new Demo1011().shipWithinDays2(new int[]{1, 2, 3, 1, 1}, 4));
    }
}
