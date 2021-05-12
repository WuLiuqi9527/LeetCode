package tips.p_others;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定由若干 0 和 1 组成的数组 A。
 * 我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 * 返回布尔值列表answer，只有当 N_i 可以被 5 整除时，答案answer[i] 为 true，否则为 false。
 * <p>
 * 输入：[0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 * <p>
 * 输入：[1,1,1]
 * 输入数字为 1, 11, 111；也就是十进制中的 1, 3, 7 。没有一个数可以被 5 整除。
 * 输出：[false,false,false]
 *
 * @author hc
 */
public class Demo1018 {

    public List<Boolean> prefixesDivBy5(int[] A) {

        List<Boolean> booleans = new ArrayList<>();

        int num = 0;
        for (int a : A) {
            num <<= 1;
            num += a;
            num %= 10;
            booleans.add(num % 5 == 0);
        }
        return booleans;
    }

    public static void main(String[] args) {

        System.out.println(new Demo1018().prefixesDivBy5(new int[]{0, 1, 1}));
    }
}
