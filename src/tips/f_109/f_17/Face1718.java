package tips.f_109.f_17;

import java.util.*;

/**
 * 假设你有两个数组，一个长一个短，短的元素均不相同。
 * 找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 * <p>示例 1:
 * 输入:
 * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
 * small = [1,5,9]
 * 输出: [7,10]
 * <p>示例 2:
 * 输入:
 * big = [1,2,3]
 * small = [4]
 * 输出: []
 * <p>提示：
 * big.length <= 100000
 * 1 <= small.length <= 100000
 *
 * @author hc
 */
public class Face1718 {
    /**
     * 类似 p_76
     */
    public int[] shortestSeq(int[] big, int[] small) {
        /**
         * 滑动窗口
         * 不要求顺序 出现频率 区分大小写
         */
        if (big == null || big.length == 0 || small == null || small.length == 0 || big.length < small.length) {
            return new int[0];
        }

        int len = big.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int s : small) {
            map.put(s, 1);
        }
        // 双指针左端点
        int l = 0, r = -1;
        // 已经找出多少个数
        int needCount = small.length;
        // 记录答案
        int[] res = new int[]{0, len};
        // 枚举双指针右端点
        while (r + 1 < len) {
            Integer num = map.get(big[++r]);
            if (num == null) {
                continue;
            }
            map.put(big[r], --num);

            if (num == 0) {
                --needCount;
            }

            if (needCount == 0) {
                while (l < r) {
                    num = map.get(big[l]);
                    if (num != null) {
                        if (num == 0) {
                            break;
                        }
                        map.put(big[l], ++num);
                    }
                    ++l;
                }

                if (res[1] - res[0] > r - l) {
                    res[0] = l;
                    res[1] = r;
                }
            }
        }

        return res[1] - res[0] == len ? new int[0] : res;
    }

    public static void main(String[] args) {
        new Face1718().shortestSeq(new int[]{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7}, new int[]{1, 5, 9});
    }
}
