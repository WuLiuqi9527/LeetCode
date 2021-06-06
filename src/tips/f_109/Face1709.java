package tips.f_109;

/**
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。
 * 注意，不是必须有这些素因子，而是必须不包含其他的素因子。
 * 例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 * <p>
 * 示例 1:
 * 输入: k = 5
 * 输出: 9
 *
 * @author hc
 */
public class Face1709 {

    public int getKthMagicNumber(int k) {

        if (k == 1) {
            return k;
        }
        int[] res = new int[k];
        res[0] = 1;
        int[] index = new int[3];
        for (int i = 1; i < k; i++) {
            int three = res[index[0]] * 3;
            int five = res[index[1]] * 5;
            int seven = res[index[2]] * 7;

            int tem = Math.min(three, Math.min(five, seven));
            if (tem == three) {
                ++index[0];
            }
            if (tem == five) {
                ++index[1];
            }
            if (tem == seven) {
                ++index[2];
            }

            res[i] = tem;
        }
        return res[k - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Face1709().getKthMagicNumber(5));
    }
}
