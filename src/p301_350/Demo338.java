package p301_350;

import java.util.ArrayList;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,1]
 * <p>
 * 示例 2:
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * @author hc
 */
public class Demo338 {

    public int[] countBits(int num) {

        if (num == 0) {
            return new int[]{0};
        }
        if (num == 1) {
            return new int[]{0, 1};
        }

        int[] memo = new int[num + 1];
        memo[0] = 0;
        memo[1] = 1;

        // 若最低位是0 i >> 1 和 i 中的 1 个数相等 而 i>>1 已经计算过了
        // 若最低位是1 i >> 1 和 i 中的 1 个数相差1
        for (int i = 2; i < num + 1; i++) {
            memo[i] = memo[i >> 1] + (i & 1);
        }

        return memo;
    }

    public static void main(String[] args) {
        int[] res = new Demo338().countBits(5);

        for (int i : res) {
            System.out.print(" ");
            System.out.print(i);
        }
    }
}
