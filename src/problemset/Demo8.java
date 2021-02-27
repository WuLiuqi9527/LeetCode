package problemset;

/**
 * @author hc
 * <p>
 * 8. 字符串转换整数 (atoi)
 * <p>
 * 请你来实现一个atoi函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * <p>
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 */

public class Demo8 {

    public static int myAtoi(String s) {
        int res = 0;
        // state == 0 为初始状态 ，1 为正整数状态 ，2为负整数
        int state = 0;
        for (char i : s.toCharArray()) {
            if (state == 0 && i == ' ') {
                continue;
            } else if (state == 0 && i == '+') {
                state = 1;
            } else if (state == 0 && i == '-') {
                state = 2;
            } else if (i >= '0' && i <= '9') {
                if (state == 0) {
                    state = 1;
                }
                int tmp = i - '0';
                if (res > (Integer.MAX_VALUE - tmp) / 10) {
                    if (state == 1) {
                        return Integer.MAX_VALUE;
                    } else if (state == 2) {
                        return Integer.MIN_VALUE;
                    }
                }
                res = res * 10 + tmp;
            } else {
                break;
            }
        }
        return (state / 2 == 1) ? -res : res;
    }

    public static void main(String[] args) {
        String[] str = {"042", " +42", "-42"};
        for (String s:str){
            System.out.println(Demo8.myAtoi(s));
        }
    }
}
