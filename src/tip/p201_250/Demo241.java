package tip.p201_250;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
 * 你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 * <p>
 * 示例 1:
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * <p>
 * 示例 2:
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * @author hc
 */
public class Demo241 {

    public List<Integer> diffWaysToCompute(String expression) {

        int len = expression.length();
        List<Integer> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        for (int i = 0; i < len; i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> res1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> res2 = diffWaysToCompute(expression.substring(i + 1, len));
                for (Integer r1 : res1) {
                    for (Integer r2 : res2) {
                        if (c == '+') {
                            res.add(r1 + r2);
                        } else if (c == '-') {
                            res.add(r1 - r2);
                        } else if (c == '*') {
                            res.add(r1 * r2);
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.valueOf(expression));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo241().diffWaysToCompute("2*3-4*5"));
    }
}
