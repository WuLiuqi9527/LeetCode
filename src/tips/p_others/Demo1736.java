package tips.p_others;

/**
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 * <p>示例 1：
 * 输入：time = "2?:?0"
 * 输出："23:50"
 * 解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
 * <p>示例 2：
 * 输入：time = "0?:3?"
 * 输出："09:39"
 * <p>示例 3：
 * 输入：time = "1?:22"
 * 输出："19:22"
 * <p>提示：
 * time 的格式为 hh:mm
 * 题目数据保证你可以由输入的字符串生成有效的时间
 *
 * @author hc
 */
public class Demo1736 {

    public String maximumTime(String time) {
        char[] arr = time.toCharArray();
        if (arr[0] == '?') {
            arr[0] = ('4' <= arr[1] && arr[1] <= '9') ? '1' : '2';
        }
        if (arr[1] == '?') {
            arr[1] = (arr[0] == '2') ? '3' : '9';
        }
        if (arr[3] == '?') {
            arr[3] = '5';
        }
        if (arr[4] == '?') {
            arr[4] = '9';
        }
        return new String(arr);
    }

    public String maximumTime2(String time) {
        StringBuilder sb = new StringBuilder();
        sb.append(time.charAt(0) == '?' ? (time.charAt(1) == '?' || time.charAt(1) < '4') ? '2' : '1' : time.charAt(0));
        sb.append(time.charAt(1) == '?' ? sb.charAt(0) == '2' ? '3' : '9' : time.charAt(1));
        sb.append(':');
        sb.append(time.charAt(3) == '?' ? '5' : time.charAt(3));
        sb.append(time.charAt(4) == '?' ? '9' : time.charAt(4));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Demo1736().maximumTime("2?:?0"));
        System.out.println(new Demo1736().maximumTime("0?:3?"));
        System.out.println(new Demo1736().maximumTime("1?:22"));
    }
}
