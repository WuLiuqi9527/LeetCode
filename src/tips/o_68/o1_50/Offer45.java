package tips.o_68.o1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>示例 1:
 * 输入: [10,2]
 * 输出: "102"
 * <p>示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * <p>提示:
 * 0 < nums.length <= 100
 * <p>说明:
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 *
 * @author hc
 */
public class Offer45 {

    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        return String.join("", list);
    }

    public static void main(String[] args) {
        System.out.println(new Offer45().minNumber(new int[]{10, 2}));
        System.out.println(new Offer45().minNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
