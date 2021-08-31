package tips.p_others;

/**
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 * 请你返回一个长度为 n 的数组 answer，其中 answer[i] 是航班 i 上预订的座位总数。
 * <p>示例 1：
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 * <p>示例 2：
 * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
 * 输出：[10,25]
 * 解释：
 * 航班编号        1   2
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       15
 * 总座位数：      10  25
 * 因此，answer = [10,25]
 * <p>提示：
 * 1 <= n <= 2 * 10^4
 * 1 <= bookings.length <= 2 * 10^4
 * bookings[i].length == 3
 * 1 <= firsti <= lasti <= n
 * 1 <= seatsi <= 10^4
 *
 * @author hc
 */
public class Demo1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] c = new int[n];
        for (int[] b : bookings) {
            int l = b[0] - 1, r = b[1] - 1, num = b[2];
            // 模拟 时间复杂度高
            for (int i = l; i <= r; i++) {
                c[i] += num;
            }
        }
        return c;
    }

    public int[] corpFlightBookings2(int[][] bs, int n) {
        /**
         * 差分数组+前缀和。
         * bookings二维数组每一行有三个数，前两个数代表区间左右端点，最后一个数代表数量，这个数量只对区间内的航班“有效”,
         * 所以在左端点进行+操作，在区间结束的第一个位置进行-操作然后对差分数组求前缀和即可。
         * 举个例子，比如 [2,4,10]这三个数，表明从第航班编号2、3、4处都预定了10个，
         * 所以10这个数量只对 2、3、4有效，在差分数组的 2处 +10，在差分数组的 5处，10失去作用 -10 即可。
         */
        int[] c = new int[n + 1];
        for (int[] bo : bs) {
            int l = bo[0] - 1, r = bo[1] - 1, v = bo[2];
            c[l] += v;
            c[r + 1] -= v;
        }
        int[] ans = new int[n];
        ans[0] = c[0];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + c[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        new Demo1109().corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5);
    }
}
