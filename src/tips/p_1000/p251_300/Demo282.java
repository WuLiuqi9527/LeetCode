package tips.p_1000.p251_300;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 0-9 的字符串 num 和一个目标值整数 target ，
 * 在 num 的数字之间添加 二元 运算符（不是一元）+、- 或 * ，返回所有能够得到目标值的表达式。
 * <p>示例 1:
 * 输入: num = "123", target = 6
 * 输出: ["1+2+3", "1*2*3"]
 * <p>示例 2:
 * 输入: num = "232", target = 8
 * 输出: ["2*3+2", "2+3*2"]
 * <p>示例 3:
 * 输入: num = "105", target = 5
 * 输出: ["1*0+5","10-5"]
 * <p>示例 4:
 * 输入: num = "00", target = 0
 * 输出: ["0+0", "0-0", "0*0"]
 * <p>示例 5:
 * 输入: num = "3456237490", target = 9191
 * 输出: []
 * <p>提示：
 * 1 <= num.length <= 10
 * num 仅含数字
 * -2^31 <= target <= 2^31 - 1
 *
 * @author hc
 */
public class Demo282 {

    List<String> res = new ArrayList<>();
    char[] path;
    char[] nums;
    long target;

    public List<String> addOperators(String num, int target) {
        path = new char[num.length() * 2];
        nums = num.toCharArray();
        this.target = target;
        long n = 0;
        int pathP = 0;
        for (int i = 0; i < nums.length; i++) {
            n = n * 10 + nums[i] - '0';
            path[pathP++] = nums[i];
            dfs(pathP, i + 1, 0, n);
            if (n == 0) {
                break;
            }
        }
        return res;
    }

    public void dfs(int pathP, int numP, long pre, long cur) {
        if (numP == nums.length) {
            if (pre + cur == target) {
                res.add(new String(path, 0, pathP));
            }
            return;
        }
        int op = pathP++;
        long n = 0;
        for (int i = numP; i < nums.length; i++) {
            n = n * 10 + nums[i] - '0';
            path[pathP++] = nums[i];

            path[op] = '+';
            dfs(pathP, i + 1, pre + cur, n);

            path[op] = '-';
            dfs(pathP, i + 1, pre + cur, -n);

            path[op] = '*';
            dfs(pathP, i + 1, pre, cur * n);

            if (n == 0) {
                break;
            }
        }
    }
}
