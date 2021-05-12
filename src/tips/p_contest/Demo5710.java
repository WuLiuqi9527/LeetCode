package tips.p_contest;

import java.util.PriorityQueue;

/**
 * 给你一个二维整数数组 orders ，其中每个 orders[i] = [pricei, amounti, orderTypei] 表示有 amounti 笔类型为 orderTypei 、价格为 pricei 的订单。
 * <p>
 * 订单类型 orderTypei 可以分为两种：
 * 0 表示这是一批采购订单 buy
 * 1 表示这是一批销售订单 sell
 * 注意，orders[i] 表示一批共计 amounti 笔的独立订单，这些订单的价格和类型相同。对于所有有效的 i ，由 orders[i] 表示的所有订单提交时间均早于 orders[i+1] 表示的所有订单。
 * <p>
 * 存在由未执行订单组成的 积压订单 。积压订单最初是空的。提交订单时，会发生以下情况：
 * <p>
 * 如果该订单是一笔采购订单 buy ，则可以查看积压订单中价格 最低 的销售订单 sell 。如果该销售订单 sell 的价格 低于或等于 当前采购订单 buy 的价格，则匹配并执行这两笔订单，并将销售订单 sell 从积压订单中删除。否则，采购订单 buy 将会添加到积压订单中。
 * 反之亦然，如果该订单是一笔销售订单 sell ，则可以查看积压订单中价格 最高 的采购订单 buy 。如果该采购订单 buy 的价格 高于或等于 当前销售订单 sell 的价格，则匹配并执行这两笔订单，并将采购订单 buy 从积压订单中删除。否则，销售订单 sell 将会添加到积压订单中。
 * 输入所有订单后，返回积压订单中的 订单总数 。由于数字可能很大，所以需要返回对 109 + 7 取余的结果。
 *
 * @author hc
 */
public class Demo5710 {

    public int getNumberOfBacklogOrders(int[][] orders) {

        int len = orders.length;
        // bug 大根堆 -> 积压订单中 价格最高 的采购订单
        PriorityQueue<int[]> buy = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        // sell 小根堆 -> 积压订单中 价格最低 的销售订单
        PriorityQueue<int[]> sell = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        for (int i = 0; i < len; i++) {
            if (orders[i][2] == 0) {
                buy.add(orders[i]);
                subAmount(buy,sell);
            } else {
                sell.add(orders[i]);
                subAmount(buy,sell);
            }
        }

        long res = 0;
        for (int[] b : buy) {
            res += b[1];
        }
        for (int[] s : sell) {
            res += s[1];
        }

        return (int) (res % (1000000007));
    }

    private void subAmount(PriorityQueue<int[]> buy, PriorityQueue<int[]> sell) {
        while (!buy.isEmpty() && !sell.isEmpty() && sell.peek()[0] <= buy.peek()[0]) {
            if (buy.peek()[1] >= sell.peek()[1]) {
                int[] tem = buy.poll();
                tem[1] -= sell.poll()[1];
                buy.add(tem);
            } else {
                int[] tem = sell.poll();
                tem[1] -= buy.poll()[1];
                sell.add(tem);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Demo5710().getNumberOfBacklogOrders(new int[][]{{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}}));
        System.out.println(new Demo5710().getNumberOfBacklogOrders(new int[][]{{7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}}));
        System.out.println(new Demo5710().getNumberOfBacklogOrders(new int[][]{{30, 27, 1}, {18, 9, 1}, {11, 4, 0}, {21, 11, 0}, {1, 1, 1}, {24, 20, 1}, {15, 13, 1}, {13, 3, 0}, {30, 11, 1}}));
    }
}
