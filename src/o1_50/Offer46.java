package o1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有 5种不同的翻译，分别是 "bccfi", "bwfi", "bczi", "mcfi"和 "mzi"
 * <p>提示：
 * 0 <= num < 2^31
 *
 * @author hc
 */
public class Offer46 {

    /**
     * 不同翻译的数量 -> dp
     * 不同翻译是什么 -> 回溯
     */
    public int translateNum(int num) {
        // dp
        String str = String.valueOf(num);
        int len = str.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            String tem = str.substring(i - 2, i);
            if (tem.compareTo("10") >= 0 && tem.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }

    public int translateNum2(int num) {
        // 递归
        if (num <= 9) {
            return 1;
        }

        // 余数 12258 % 100 == 58
        //      703  % 100 == 3     都只能翻译为一位
        int n = num % 100;
        if (n <= 9 || n >= 26) {
            return translateNum2(num / 10);
        } else {
            // [10, 25]两种翻译
            return translateNum2(num / 10) + translateNum2(num / 100);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Offer46().translateNum2(12258));
    }
}
