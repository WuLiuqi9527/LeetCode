package p51_100;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * @author hc
 */
public class Demo69 {

    /**
     * 牛顿法 切线导数逼近
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        // 牛顿迭代法初值
        double xn = x > 2 ? x / 2 : 1;

        while (Math.abs(xn * xn - x) > 0.5) {
            xn = (xn + x / xn) / 2;
        }

        return (int) xn;
    }

    /**
     * 二分查找
     */
    public int mySqrt2(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public int mySqrt3(int x) {
        return (int) Math.sqrt(x);
    }
}
