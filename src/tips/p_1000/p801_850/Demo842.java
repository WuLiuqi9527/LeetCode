package tips.p_1000.p801_850;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 * <p>示例 1：
 * 输入："123456579"
 * 输出：[123,456,579]
 * <p>示例 2：
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * <p>示例 3：
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 * <p>示例 4：
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * <p>示例 5：
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 * <p>提示：
 * 1 <= S.length <= 200
 * 字符串 S 中只含有数字。
 *
 * @author hc
 */
public class Demo842 {

    List<Integer> list;

    public List<Integer> splitIntoFibonacci(String num) {
        list = new ArrayList<>();
        dfs(num, 0, num.length());
        return list;
    }

    private boolean dfs(String num, int index, int len) {
        if (index == len && list.size() >= 3) {
            return true;
        }

        for (int i = index; i < len; i++) {
            // 两位以上的数字不能以 0 开头
            if (num.charAt(index) == '0' && i > index) {
                break;
            }
            // 截取字符串转化为数字
            long subNum = Long.valueOf(num.substring(index, i + 1));
            // 如果截取的数字大于int的最大值，则终止截取
            if (subNum > Integer.MAX_VALUE) {
                break;
            }

            // 如果截取的数字大于 res 中前两个数字的和，说明这次截取的太大，直接终止，因为后面越截取越大
            int size = list.size();
            if (size > 1 && subNum > list.get(size - 1) + list.get(size - 2)) {
                break;
            }

            if (size <= 1 || subNum == list.get(size - 1) + list.get(size - 2)) {
                list.add((int) subNum);
                if (dfs(num, i + 1, len)) {
                    return true;
                }
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Demo842().splitIntoFibonacci("5511816597"));
    }
}
