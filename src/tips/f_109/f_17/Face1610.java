package tips.f_109.f_17;

/**
 * 给定 N 个人的出生年份和死亡年份，第 i 个人的出生年份为 birth[i]，死亡年份为 death[i]，
 * 实现一个方法以计算生存人数最多的年份。
 * 你可以假设所有人都出生于 1900 年至 2000 年（含 1900 和 2000 ）之间。
 * 如果一个人在某一年的任意时期处于生存状态，那么他应该被纳入那一年的统计中。
 * 例如，生于 1908 年、死于 1909 年的人应当被列入 1908 年和 1909 年的计数。
 * 如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
 * <p>示例：
 * 输入：
 * birth = {1900, 1901, 1950}
 * death = {1948, 1951, 2000}
 * 输出： 1901
 * <p>提示：
 * 0 < birth.length == death.length <= 10000
 * birth[i] <= death[i]
 *
 * @author hc
 */
public class Face1610 {

    public int maxAliveYear(int[] birth, int[] death) {
        int[] time = new int[101];
        int len = birth.length;
        for (int i = 0; i < len; i++) {
            for (int j = birth[i]; j <= death[i]; j++) {
                ++time[j - 1900];
            }
        }

        int[] max = new int[2];
        for (int i = 0; i < time.length; i++) {
            if (time[i] > max[0]) {
                max[0] = time[i];
                max[1] = i;
            }
        }
        return max[1] + 1900;
    }

    public int maxAliveYear2(int[] birth, int[] death) {
        int[] time = new int[102];
        int len = birth.length;
        for (int i = 0; i < len; i++) {
            ++time[birth[i] - 1900];
            --time[death[i] - 1900 + 1];
        }

        int sum = 0, max = 0, year = 0;
        for (int i = 0; i < time.length; i++) {
            sum += time[i];
            if (sum > max) {
                max = sum;
                year = i;
            }
        }
        return year + 1900;
    }

    public static void main(String[] args) {
        System.out.println(new Face1610().maxAliveYear2(new int[]{1900, 1901, 1950}, new int[]{1948, 1951, 2000}));
    }
}
