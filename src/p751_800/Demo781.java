package p751_800;

/**
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。
 * 我们将这些回答放在 answers 数组里。
 * 返回森林中兔子的 最少 数量。
 * <p>
 * 示例:
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 * 输入: answers = []
 * 输出: 0
 * <p>
 * 说明:
 * answers 的长度最大为1000。
 * answers[i] 是在 [0, 999] 范围内的整数。
 *
 * @author hc
 */
public class Demo781 {

    public int numRabbits(int[] answers) {

        /**
         * 我们统计数组中所有回答 x 的兔子的数量 n：
         * 若 n % (x+1) == 0，说明我们此时只需要 n/(x+1) 种不同颜色的兔子，每种颜色兔子的个数为 x+1。
         * 若 n % (x+1) != 0，说明我们此时只需要 n/(x+1) + 1 种不同颜色的兔子，每种颜色兔子的个数为 x+1 。
         */
        int res = 0, colorNum;
        int len = 1000;
        int[] rabbit = new int[len];
        for (int answer : answers) {
            ++rabbit[answer];
        }
        for (int i = 0; i < len; i++) {
            if (rabbit[i] % (i + 1) == 0) {
                colorNum = rabbit[i] / (i + 1);
            } else {
                colorNum = rabbit[i] / (i + 1) + 1;
            }
            res += colorNum * (i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo781().numRabbits(new int[]{1, 1, 2}));
        System.out.println(new Demo781().numRabbits(new int[]{10, 10, 10}));
    }
}
