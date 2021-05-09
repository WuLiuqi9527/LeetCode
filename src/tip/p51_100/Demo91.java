package tip.p51_100;

/**
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。
 * 例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A" ，从而得到 "AAA" ，
 * 或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。
 * 注意，"06" 不能映射为 "F" ，因为 "6" 和 "06" 不同。
 * 给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * 示例 1：
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * @author hc
 */
public class Demo91 {

    public int numDecodings(String s) {

        if (s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[]{1, 1};
        for (int i = 1; i < s.length(); i++) {
            int tem = dp[1];
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    dp[1] = dp[0];
                } else {
                    return 0;
                }
            } else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2') && '1' <= s.charAt(i) && s.charAt(i) <= '6') {
                dp[1] = dp[1] + dp[0];
            }
            dp[0] = tem;
        }
        return dp[1];
    }

    public static void main(String[] args) {
        System.out.println(new Demo91().numDecodings("0"));
    }

}
