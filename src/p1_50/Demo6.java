package p1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * @author hc
 */
public class Demo6 {

    public String convert(String s, int numRows) {

        if (numRows < 2) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        // 初始化
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            // flag 用来逆向
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }

        StringBuilder res = new StringBuilder();
        // StringBuilder 比 String 拼接快
        // 因为 String 拼接的底层就是利用 StringBuilder 实现的
        // 这样就会多余两个步骤 new StringBuilder() + new String()
        // 本质上是因为 String 无法被改变
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Demo6().convert("PAYPALISHIRING", 4));
    }
}
