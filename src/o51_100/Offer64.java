package o51_100;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>示例 1：
 * 输入: n = 3
 * 输出: 6
 * <p>示例 2：
 * 输入: n = 9
 * 输出: 45
 * <p>限制：
 * 1 <= n <= 10000
 *
 * @author hc
 */
public class Offer64 {

    public int sumNums(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumNums(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Offer64().sumNums(3));
        System.out.println(new Offer64().sumNums(9));
    }
}
