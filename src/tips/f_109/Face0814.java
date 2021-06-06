package tips.f_109;

/**
 * 给定一个布尔表达式和一个期望的布尔结果 result，
 * 布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR) 符号组成。
 * 实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。
 * <p>示例 1:
 * 输入: s = "1^0|0|1", result = 0
 * 输出: 2
 * 解释: 两种可能的括号方法是
 * 1^(0|(0|1))
 * 1^((0|0)|1)
 * <p>示例 2:
 * 输入: s = "0&0&0&1^1|0", result = 1
 * 输出: 10
 * <p>提示：
 * 运算符的数量不超过 19 个
 *
 * @author hc
 */
public class Face0814 {

    /**
     * 回溯
     */
    public int countEval(String s, int result) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return (s.charAt(0) - '0') == result ? 1 : 0;
        }

        int len = s.length();
        int[][][] cache = new int[len][len][];
        int[] res = backtrack(s.toCharArray(), 0, len - 1, cache);
        return result == 0 ? res[0] : res[1];
    }

    private int[] backtrack(char[] chars, int left, int right, int[][][] cache) {
        int[] res = new int[2];
        if (left >= right) {
            res[chars[left] - '0'] = 1;
            return res;
        }
        // 记忆化搜索
        if (cache[left][right] != null) {
            return cache[left][right];
        }

        for (int i = left; i <= right; i++) {
            if (chars[i] == '0' || chars[i] == '1') {
                continue;
            }

            // 当前 i 为符号, l 左边有几种可能 r 右边有几种可能
            int[] l = backtrack(chars, left, i - 1, cache);
            int[] r = backtrack(chars, i + 1, right, cache);
            switch (chars[i]) {
                case '&':
                    // 结果为0 三种情况：0&0，0&1，1&0
                    // 结果为1 一种情况：1&1
                    res[0] += (l[0] * r[0]) + (l[0] * r[1]) + (l[1] * r[0]);
                    res[1] += l[1] * r[1];
                    break;
                case '|':
                    // 结果为0 一种情况：0|0
                    // 结果为1 三种情况：1|1，0|1，1|0
                    res[0] += l[0] * r[0];
                    res[1] += (l[1] * r[1]) + (l[0] * r[1]) + (l[1] * r[0]);
                    break;
                case '^':
                    // 结果为0 二种情况：0^0，1^1
                    // 结果为1 两种情况：0^1，1^0
                    res[0] += (l[0] * r[0]) + (l[1] * r[1]);
                    res[1] += (l[0] * r[1]) + (l[1] * r[0]);
                    break;
                default:
                    break;
            }
        }
        // 缓存结果
        cache[left][right] = res;
        return res;
    }
}
