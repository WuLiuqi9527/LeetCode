package tips.p_1000.p701_750;

/**
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * <p>示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * <p>示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * <p>提示：
 * 1 <= temperatures.length <= 10^5
 * 30 <= temperatures[i] <= 100
 *
 * @author hc
 */
public class Demo739 {

    public int[] dailyTemperatures(int[] T) {
        // 暴力
        int len = T.length;
        int[] res = new int[len];
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (T[i] < T[j]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j += res[j]) {
                if (T[i] < T[j]) {
                    res[i] = j - i;
                    break;
                } else if (res[j] == 0) {
                    res[i] = 0;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Demo739().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        new Demo739().dailyTemperatures(new int[]{30, 40, 50, 60});
        new Demo739().dailyTemperatures(new int[]{30, 60, 90});
    }
}
