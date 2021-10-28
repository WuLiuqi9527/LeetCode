package tips.p_1000.p851_900;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 * <p>示例 1：
 * 输入：1
 * 输出：true
 * <p>示例 2：
 * 输入：10
 * 输出：false
 * <p>示例 3：
 * 输入：16
 * 输出：true
 * <p>示例 4：
 * 输入：24
 * 输出：false
 * <p>示例 5：
 * 输入：46
 * 输出：true
 * <p>提示：
 * 1 <= N <= 10^9
 *
 * @author hc
 */
public class Demo869 {

    static Set<Integer> set = new HashSet<>();

    static {
        for (int i = 1; i < (int) 1e9 + 10; i *= 2) {
            set.add(i);
        }
    }

    public boolean reorderedPowerOf2(int n) {
        int[] cnts = new int[10];
        while (n != 0) {
            cnts[n % 10]++;
            n /= 10;
        }
        int[] cur = new int[10];
        out:
        for (int x : set) {
            Arrays.fill(cur, 0);
            while (x != 0) {
                cur[x % 10]++;
                x /= 10;
            }
            for (int i = 0; i < 10; i++) {
                if (cur[i] != cnts[i]) {
                    continue out;
                }
            }
            return true;
        }
        return false;
    }
}
