package tip.p1_50;

/**
 * 外观数列
 * 描述前一项 1 < n < 30
 *
 * @author hc
 */
public class Demo38 {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String num = countAndSay(n - 1);

        StringBuilder res = new StringBuilder();
        int start = 0;
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) != num.charAt(start)){
                res.append(i-start).append(num.charAt(start));
                start = i;
            }
        }
        res.append(num.length() - start).append(num.charAt(start));

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Demo38().countAndSay(1));
        System.out.println(new Demo38().countAndSay(2));
        System.out.println(new Demo38().countAndSay(3));
        System.out.println(new Demo38().countAndSay(4));
        System.out.println(new Demo38().countAndSay(5));
    }
}
