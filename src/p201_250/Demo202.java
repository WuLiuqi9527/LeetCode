package p201_250;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为 1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 * <p>
 * 示例 1：
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 *
 * @author hc
 */
public class Demo202 {

    public boolean isHappy(int n) {

        // 取巧 十次循环
        for (int i = 0; i < 10; i++) {
            int ans = 0;
            while (n > 0) {
                ans += (n % 10) * (n % 10);
                n = n / 10;
            }
            n = ans;
            if (n == 1) {
                return true;
            }
        }

        return false;
    }
}
