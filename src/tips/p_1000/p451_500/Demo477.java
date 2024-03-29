package tips.p_1000.p451_500;

/**
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 * <p>示例:
 * 输入: 4, 14, 2
 * 输出: 6
 * 解释: 在二进制表示中，4表示为0100，14表示为 1110，2表示为 0010。
 * （这样表示是为了体现后四位之间关系）
 * 所以答案为：HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * <p>注意:
 * 数组中元素的范围为从 0到 10^9。
 * 数组的长度不超过 10^4。
 *
 * @author hc
 */
public class Demo477 {

    public int totalHammingDistance(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                res += hammingDistance(nums[i], nums[j]);
            }
        }
        return res;
    }

    public int totalHammingDistance2(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bit0 = 0;
            int bit1 = 0;
            for (int num : nums) {
                if ((num & (1 << i)) == 0) {
                    ++bit0;
                }else {
                    ++bit1;
                }
            }
            res += bit0 * bit1;
        }
        return res;
    }

    public int totalHammingDistance3(int[] nums) {
        int res = 0, len = nums.length;
        for (int i = 0; i < 32; i++) {
            int bit = 0;
            for (int num : nums) {
                bit += (num >> i) & 1;
            }
            res += bit * (len - bit);
        }
        return res;
    }

    private int hammingDistance(int a, int b) {
        return Integer.bitCount(a ^ b);
    }

    public static void main(String[] args) {
        System.out.println(new Demo477().totalHammingDistance2(new int[]{4, 14, 2}));
    }
}
