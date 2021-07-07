package tips.p_others;

import java.util.HashMap;
import java.util.Map;

/**
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * 你可以搭配 任意 两道餐品做一顿大餐。
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，
 * 返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 10^9 + 7 取余。
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 * <p>示例 1：
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 * <p>示例 2：
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 * <p>提示：
 * 1 <= deliciousness.length <= 10^5
 * 0 <= deliciousness[i] <= 2^20
 *
 * @author hc
 */
public class Demo1711 {

    final int MOD = 10_0000_0007;

    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        long res = 0;
        for (int num : deliciousness) {
            int two = 1;
            for (int i = 0; i <= 21; i++) {
                if (two >= num && map.containsKey(two - num)) {
                    res += map.get(two - num);
                }
                two <<= 1;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return (int) (res % MOD);
    }

    public int countPairs2(int[] deliciousness) {
        // 使用数组模拟 HashMap
        int min = deliciousness[0], max = deliciousness[0];
        for (int d : deliciousness) {
            if (d < min) {
                min = d;
            } else if (d > max) {
                max = d;
            }
        }
        int[] map = new int[max - min + 1];
        long res = 0;
        for (int num : deliciousness) {
            for (int two = 1; ; two <<= 1) {
                int tem = two - num;
                if (tem < min) {
                    continue;
                }
                if (tem > max) {
                    break;
                }
                res += map[tem - min];
            }
            ++map[num - min];
        }
        return (int) (res % MOD);
    }
}
