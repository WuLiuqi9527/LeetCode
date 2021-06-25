package tips.f_109.f_17;

import tips.p_1000.p251_300.Demo273;

/**
 * 给定一个整数，打印该整数的英文描述。
 * <p>示例 1:
 * 输入: 123
 * 输出: "One Hundred Twenty Three"
 * <p>示例 2:
 * 输入: 12345
 * 输出: "Twelve Thousand Three Hundred Forty Five"
 * <p>示例 3:
 * 输入: 1234567
 * 输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * <p>示例 4:
 * 输入: 1234567891
 * 输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 *
 * @author hc
 */
public class Face1608 {

    private final String[] THOUSAND = {"", "Thousand", "Million", "Billion"};
    private final String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] HUNDRED = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                StringBuilder tmp = new StringBuilder();
                helper(num % 1000, tmp);
                sb.insert(0, tmp.append(THOUSAND[index]).append(" "));
            }
            index++;
            num /= 1000;
        }
        return sb.toString().trim();
    }

    private void helper(int num, StringBuilder tmp) {
        if (num == 0) {
            return;
        }
        if (num < 20) {
            tmp.append(LESS_THAN_TWENTY[num]).append(" ");
        } else if (num < 100) {
            tmp.append(HUNDRED[num / 10]).append(" ");
            helper(num % 10, tmp);
        } else {
            tmp.append(LESS_THAN_TWENTY[num / 100]).append(" Hundred").append(" ");
            helper(num % 100, tmp);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Demo273().numberToWords(123));
    }
}
