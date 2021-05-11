package tip.lt1000.p951_1000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 对于非负整数 X 而言，X的数组形式是每位数字按从左到右的顺序形成的数组。
 * 例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * <p>
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * <p>
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 *
 * @author hc
 */

public class Demo989 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = A.length - 1; i >= 0; i--) {
            int sum = A[i] + K % 10;
            K /= 10;
            if (sum >= 10) {
                K++;
                sum -= 10;
            }
            res.add(sum);
        }
        for (; K > 0; K /= 10) {
            res.add(K % 10);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo989().addToArrayForm(new int[]{1, 2, 0, 0}, 34));
    }
}
