package o1_50;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * <p>说明：
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 * @author hc
 */
public class Offer17 {

    public int[] printNumbers(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("输入错误");
        }

        int len = (int) (Math.pow(10,n) - 1);
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        new Offer17().printNumbers(3);
    }
}
