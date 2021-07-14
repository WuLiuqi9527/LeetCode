package tips.p_1000.p201_250;

import java.util.*;

/**
 * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。
 * 给你所有建筑物的位置和高度，请返回由这些建筑物形成的 天际线 。
 * 每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：
 * lefti 是第 i 座建筑物左边缘的 x 坐标。
 * righti 是第 i 座建筑物右边缘的 x 坐标。
 * heighti 是第 i 座建筑物的高度。
 * 天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。
 * 关键点是水平线段的左端点。列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。
 * 此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 * 注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 * <p>示例 1：
 * 输入：buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * 输出：[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 * 解释：
 * 图 A 显示输入的所有建筑物的位置和高度，
 * 图 B 显示由这些建筑物形成的天际线。图 B 中的红点表示输出列表中的关键点。
 * <p>示例 2：
 * 输入：buildings = [[0,2,3],[2,5,3]]
 * 输出：[[0,3],[5,0]]
 * <p>提示：
 * 1 <= buildings.length <= 10^4
 * 0 <= lefti < righti <= 2^31 - 1
 * 1 <= heighti <= 2^31 - 1
 * buildings 按 lefti 非递减排序
 *
 * @author hc
 */
public class Demo218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int[] building : buildings) {
            pq.offer(new int[]{building[0], -building[2]});
            pq.offer(new int[]{building[1], building[2]});
        }

        List<List<Integer>> res = new ArrayList<>();

        TreeMap<Integer, Integer> heights = new TreeMap<>((a, b) -> b - a);
        heights.put(0, 1);
        int left = 0, height = 0;
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            if (arr[1] < 0) {
                heights.put(-arr[1], heights.getOrDefault(-arr[1], 0) + 1);
            } else {
                heights.put(arr[1], heights.get(arr[1]) - 1);
                if (heights.get(arr[1]) == 0) {
                    heights.remove(arr[1]);
                }
            }
            int maxHeight = heights.keySet().iterator().next();
            if (maxHeight != height) {
                left = arr[0];
                height = maxHeight;
                res.add(Arrays.asList(left, height));
            }
        }
        return res;
    }

    // 线段树
    public List<List<Integer>> getSkyline2(int[][] buildings) {
        int len = buildings.length;
        if (len == 0) {
            return new ArrayList<>();
        }
        return segment(buildings, 0, len - 1);
    }

    private List<List<Integer>> segment(int[][] buildings, int l, int r) {
        // 创建返回值
        List<List<Integer>> res = new ArrayList<>();

        // 找到树底下的结束条件 -> 一个建筑物
        if (l == r) {
            res.add(Arrays.asList(buildings[l][0], buildings[l][2])); // 左上端坐标
            res.add(Arrays.asList(buildings[l][1], 0)); // 右下端坐标
            return res;
        }

        int mid = l + (r - l) / 2; // 取中间值

        // 左边递归
        List<List<Integer>> left = segment(buildings, l, mid);

        // 右边递归
        List<List<Integer>> right = segment(buildings, mid + 1, r);

        // 左右合并

        // 创建left 和 right 的索引位置
        int m = 0, n = 0;
        // 创建left 和 right 目前的高度
        int lpreH = 0, rpreH = 0;
        // 两个坐标
        int leftX, leftY, rightX, rightY;
        while (m < left.size() || n < right.size()) {

            // 当有一边完全加入到res时，则加入剩余的那部分
            if (m >= left.size()) {
                res.add(right.get(n++));
            } else if (n >= right.size()) {
                res.add(left.get(m++));
            } else { // 开始判断left 和 right
                leftX = left.get(m).get(0); // 不会出现null，可以直接用int类型
                leftY = left.get(m).get(1);
                rightX = right.get(n).get(0);
                rightY = right.get(n).get(1);
                //看我这两个矩形谁靠左
                if (leftX < rightX) {
                    //左面还比以前高，就加左面
                    if (leftY > rpreH) {
                        res.add(left.get(m));
                    } else if (lpreH > rpreH) {
                        //左面比右面高，我要加入左面点的以及以前右面的的高度，因为我马上就有新高度了2，10
                        res.add(Arrays.asList(leftX, rpreH));
                    }
                    //  用我左面的高替换我以前右面的高
                    lpreH = leftY;
                    m++;
                } else if (leftX > rightX) {
                    if (rightY > lpreH) {
                        res.add(right.get(n));
                    } else if (rpreH > lpreH) {
                        res.add(Arrays.asList(rightX, lpreH));
                    }
                    rpreH = rightY;
                    n++;
                } else { // left 和 right 的横坐标相等
                    if (leftY >= rightY && leftY != (lpreH > rpreH ? lpreH : rpreH)) {
                        res.add(left.get(m));
                    } else if (leftY <= rightY && rightY != (lpreH > rpreH ? lpreH : rpreH)) {
                        res.add(right.get(n));
                    }
                    lpreH = leftY;
                    rpreH = rightY;
                    m++;
                    n++;
                }
            }
        }
        return res;
    }
}
