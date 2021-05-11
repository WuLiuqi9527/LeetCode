package tip.lt1000.p51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 * 格雷编码序列必须以 0 开头。
 * <p>
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 对于给定的 n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 *
 * @author hc
 */
public class Demo89 {

    public List<Integer> grayCode(int n) {
        /**
         关键是搞清楚格雷编码的生成过程, G(i) = i ^ (i >>> 1);
         如 n = 3:
         G(0) = 000,
         G(1) = 1 ^ 0 = 001 ^ 000 = 001
         G(2) = 2 ^ 1 = 010 ^ 001 = 011
         G(3) = 3 ^ 1 = 011 ^ 001 = 010
         G(4) = 4 ^ 2 = 100 ^ 010 = 110
         G(5) = 5 ^ 2 = 101 ^ 010 = 111
         G(6) = 6 ^ 3 = 110 ^ 011 = 101
         G(7) = 7 ^ 3 = 111 ^ 011 = 100
         **/
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; ++i) {
            res.add(i ^ i >>> 1);
        }
        return res;
    }

    /**
     * 回溯
     */
    List<Integer> res;
    boolean[] used;

    public List<Integer> grayCode2(int n) {

        res = new ArrayList<>();
        used = new boolean[1 << n];
        dfs(0, n);
        return res;
    }

    private void dfs(int cur, int n) {
        if (res.size() == (1 << n)) {
            return;
        }

        res.add(cur);
        used[cur] = true;
        for (int i = 0; i < n; i++) {
            // 异或 使得只有一位不一样
            int next = cur ^ (1 << i);
            if (!used[next]) {
                dfs(next, n);
            }
        }
    }

    public static void main(String[] args) {
        new Demo89().grayCode2(3);
    }
}
