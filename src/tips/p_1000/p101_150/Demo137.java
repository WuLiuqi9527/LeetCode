package tips.p_1000.p101_150;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * 输入: [2,2,3,2]
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 * @author hc
 */
public class Demo137 {

    public int singleNumber(int[] nums) {
        int res = 0, number;
        for (int i = 0; i < 32; i++) {
            number = 0;
            for (int num : nums) {
                number += (num >> i) & 1;
            }
            res |= (number % 3) << i;
        }
        return res;
    }

    public int singleNumber2(int[] nums) {
        // 逻辑电路 模三运算
        // XY   Z   X’  Y'
        // 00	0	0	0
        // 01	0	0	1
        // 10	0	1	0
        // 00	1	0	1
        // 01	1	1	0
        // 10	1	0	0
        // -> Y' = ~XY~Z + ~X~YZ = ~X & (Y ^ Z)
        // -> X‘ = X~Y~Z + ~XYZ = ~Y' & (X ^ Z)
        // x & ~0 = x;
        int X = 0, Y = 0;
        for (int Z : nums) {
            Y = (Y ^ Z) & ~X;
            X = (X ^ Z) & ~Y;
        }
        return Y;
    }

    public static void main(String[] args) {
        System.out.println(new Demo137().singleNumber2(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
