package o51_100;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为 1，J为 11，Q为 12，K为 13，而大、小王为 0 ，可以看成任意数字。
 * A 不能视为 14。
 * <p>示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 * <p>限制：
 * 数组长度为 5
 * 数组的数取值为 [0, 13] .
 *
 * @author hc
 */
public class Offer61 {

    public boolean isStraight(int[] nums) {
        // 只有5张牌，先排除对子，然后求最大和最小的牌面之差，小于等于4就肯定是顺子
        int[] cover = new int[14];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (cover[num] == 1) {
                return false;
            }
            ++cover[num];

            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return max - min <= 4;
    }
}
