package tips.p_1000.p401_450;

import java.util.ArrayList;
import java.util.List;

/**
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * <p>示例：
 * n = 15,
 * 返回:
 * ["1","2","Fizz","4","Buzz","Fizz","7","8",
 * "Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 *
 * @author hc
 */
public class Demo412 {

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean num3 = i % 3 == 0;
            boolean num5 = i % 5 == 0;
            String str;
            if (num3 && num5) {
                str = "FizzBuzz";
            } else if (num3) {
                str = "Fizz";
            } else if (num5) {
                str = "Buzz";
            } else {
                str = String.valueOf(i);
            }
            res.add(str);
        }
        return res;
    }
}
