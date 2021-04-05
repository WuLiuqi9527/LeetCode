package p151_200;

import java.util.Arrays;

/**
 * 定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * <p>示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 *
 * <p>示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *
 * @author hc
 */
public class Demo179 {

    public String largestNumber(int[] nums) {

        int len = nums.length;
        if (nums == null || len == 0) {
            return "";
        }

        String[] strings = new String[len];
        for (int i = 0; i < len; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (strings[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Demo179().largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
