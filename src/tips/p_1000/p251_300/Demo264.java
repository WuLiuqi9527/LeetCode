package tips.p_1000.p251_300;

/**
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 * <p>
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * <p>
 * 说明:
 * 1 是丑数。
 * n 不超过 1690。
 *
 * @author hc
 */
public class Demo264 {

    /**
     * 下一个丑数，定义为丑数数组中的数乘以权重[2, 3, 5]，所得的最小值
     */
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;

        int[] index = new int[3];
        for (int i = 1; i < n; i++) {
            int two = res[index[0]] * 2;
            int three = res[index[1]] * 3;
            int five = res[index[2]] * 5;

            int next = Math.min(two, Math.min(three, five));
            updateIndex(index, next, two, three, five);
            res[i] = next;
        }
        return res[n - 1];
    }

    private void updateIndex(int[] index, int next, int two, int three, int five) {
        if (next == two) {
            ++index[0];
        }
        if (next == three) {
            ++index[1];
        }
        if (next == five) {
            ++index[2];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Demo264().nthUglyNumber(10));
        System.out.println(new Demo264().nthUglyNumber(1));
    }
}
