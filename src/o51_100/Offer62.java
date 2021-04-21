package o51_100;

/**
 * 0,1,···,n-1这 n 个数字排成一个圆圈，从数字 0 开始，
 * 每次从这个圆圈里删除第 m 个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这 5 个数字组成一个圆圈，从数字 0 开始每次删除第 3 个数字，
 * 则删除的前 4 个数字依次是 2、0、4、1，因此最后剩下的数字是 3。
 * <p>示例 1：
 * 输入: n = 5, m = 3
 * 输出: 3
 * <p>示例 2：
 * 输入: n = 10, m = 17
 * 输出: 2
 * <p>限制：
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 *
 * 参考：
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/jian-zhi-offer-62-yuan-quan-zhong-zui-ho-dcow/
 *
 * @author hc
 */
public class Offer62 {

    public int lastRemaining(int n, int m) {

        // 约瑟夫环
        int k = 0;
        for (int i = 2; i <= n; i++) {
            k = (k + m) % i;
        }
        return k;
    }
}
