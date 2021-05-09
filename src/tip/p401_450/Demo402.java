package tip.p401_450;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>注意:
 * num 的长度小于 10002 且  ≥ k。
 * num 不会包含任何前导零。
 * <p>示例 1 :
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * <p>示例 2 :
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * <p>示例 3 :
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * @author hc
 */
public class Demo402 {

    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len == k) {
            return "0";
        }

        StringBuilder stack = new StringBuilder();
        int remain = len - k, zero = 0;

        for (int i = 0; i < len; i++) {

            char ch = num.charAt(i);
            // 若移除指标 k, 当前栈不为空, 且栈顶元素的值大于当前遍历的元素值，则栈顶元素出栈，k 减 1
            while (k > 0 && stack.length() != 0 && stack.charAt(stack.length() - 1) > ch) {
                stack.setLength(stack.length() - 1);
                --k;
            }
            stack.append(ch);
        }

        String res = stack.substring(0, remain);
        // 移除前导 0
        while (zero < res.length() && res.charAt(zero) == '0') {
            ++zero;
        }
        if (zero != 0) {
            res = res.substring(zero);
        }

        return res.length() == 0 ? "0" : res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo402().removeKdigits("1432219", 3));
        System.out.println(new Demo402().removeKdigits("10200", 1));
        System.out.println(new Demo402().removeKdigits("10001", 4));
    }
}
