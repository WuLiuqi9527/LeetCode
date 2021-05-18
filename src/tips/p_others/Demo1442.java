package tips.p_others;

/**
 * 给你一个整数数组 arr 。
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 * a 和 b 定义如下：
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 * <p>示例 1：
 * 输入：arr = [2,3,1,6,7]
 * 输出：4
 * 解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
 * <p>示例 2：
 * 输入：arr = [1,1,1,1,1]
 * 输出：10
 * <p>示例 3：
 * 输入：arr = [2,3]
 * 输出：0
 * <p>示例 4：
 * 输入：arr = [1,3,5,7,9]
 * 输出：3
 * <p>示例 5：
 * 输入：arr = [7,11,12,9,5,2,7,17,22]
 * 输出：8
 * <p>提示：
 * 1 <= arr.length <= 300
 * 1 <= arr[i] <= 10^8
 *
 * @author hc
 */
public class Demo1442 {

    public int countTriplets(int[] arr) {

        int res = 0;
        int len = arr.length;

        // 区间异或和为 0 时, j 可以是 (i, k] 内任意数
        // 看作 j 将区间一分为二, 既然左右异或和为 0 那么必然左右相等
        for (int i = 0; i < len - 1; i++) {
            int sum = arr[i];
            for (int k = i + 1; k < len; k++) {
                sum ^= arr[k];
                if (sum == 0) {
                    res += k - i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo1442().countTriplets(new int[]{2, 3, 1, 6, 7}));
    }
}
