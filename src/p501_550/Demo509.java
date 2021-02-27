package p501_550;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 *
 * @author hc
 */
public class Demo509 {

    public int fib(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        /**
         * 记忆化搜索 自顶向下
         */
        int[] memo = new int[n+1];
        if (n > 1) {
            memo[n] = fib(n - 1) + fib(n - 2);
        }

        /**
         * 动态规划 自底向上
         */
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < n+1; i++) {
            memo[i] = memo[i-1]+memo[i-2];
        }

        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new Demo509().fib(4));
    }
}
