package p_others;

import java.util.Arrays;

/**
 * 1046. 最后一块石头的重量
 * <p>
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。
 * <p>
 * 那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为y的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 *
 * @author hc
 */

public class Demo1046 {

    public int lastStoneWeight(int[] stones) {

        if (stones.length == 1) {
            return stones[0];
        } else if (stones.length == 2) {
            return Math.abs(stones[0] - stones[1]);
        }
        Arrays.sort(stones);
        if (stones[stones.length - 2] != 0) {
            stones[stones.length - 1] = Math.abs(stones[stones.length - 1] - stones[stones.length - 2]);
            stones[stones.length - 2] = 0;
            return lastStoneWeight(stones);
        } else {
            return stones[stones.length - 1];
        }
    }

    public static void main(String[] args) {

        int lastStoneWeight = new Demo1046().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});
        int rightResult = 1;
        if (rightResult == lastStoneWeight) {
            System.out.println("Right!");
        } else {
            System.out.println("Wrong!");
        }
    }
}
