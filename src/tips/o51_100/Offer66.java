package tips.o51_100;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * <p>提示：
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 *
 * @author hc
 */
public class Offer66 {

    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] res = new int[len];

        // 当前数的左边*右边
        int left = 1;
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                left *= a[i - 1];
            }
            res[i] = left;
        }

        int right = 1;
        for (int i = len - 1; i >= 0; --i) {
            if (i < len - 1) {
                right *= a[i + 1];
            }
            res[i] *= right;
        }

        return res;
    }

    public static void main(String[] args) {
        new Offer66().constructArr(new int[]{1,2,3,4,5});
    }
}
