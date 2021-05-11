package tip.lt1000.p851_900;

import java.util.Arrays;

/**
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的 大小 ，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * <p>
 * 注意：只交换一根
 * <p>
 * 示例 1：
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 *
 * @author hc
 */
public class Demo888 {

    public int[] fairCandySwap(int[] A, int[] B) {

        int sumA = 0, sumB = 0;
        for (int a : A) {
            sumA += a;
        }
        for (int b : B) {
            sumB += b;
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int[] res = new int[2];
        int target = (sumA - sumB) / 2;
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {

            int cur = A[i] - B[j];

            if (cur == target) {
                res[0] = A[i];
                res[1] = B[j];
            }

            if (cur < target) {
                ++i;
            } else {
                ++j;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] p = new Demo888().fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4});
        System.out.print("[");
        for (int i:p){
            System.out.print(i);
        }
        System.out.println("]");
    }
}
