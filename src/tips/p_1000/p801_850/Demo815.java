package tips.p_1000.p801_850;

import java.util.*;

/**
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 * <p>示例 1：
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 * <p>示例 2：
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 * <p>提示：
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 10^5
 * routes[i] 中的所有值 互不相同
 * sum(routes[i].length) <= 10^5
 * 0 <= routes[i][j] < 10^6
 * 0 <= source, target < 10^6
 *
 * @author hc
 */
public class Demo815 {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        // 缓存 车站->路线
        HashMap<Integer, Set<Integer>> s2r = new HashMap<>();
        // 缓存 路线->车站
        HashMap<Integer, Set<Integer>> r2s = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            HashSet<Integer> stations = new HashSet<>();
            for (int station : routes[i]) {
                stations.add(station);
                // 不存在创建新set 存在把车次放入set
                s2r.computeIfAbsent(station, integer -> new HashSet<>()).add(i);
            }
            r2s.put(i, stations);
        }
        // 2.判断特殊情况
        // 没有起始节点肯定到不了
        if (!s2r.containsKey(source) || !s2r.containsKey(target)) {
            return -1;
        }
        // 在一个车上
        if (s2r.get(target) == s2r.get(source)) {
            return 0;
        }
        // 3.bfs
        int count = 0;
        Queue<Integer> queue = new LinkedList<>(s2r.get(source));
        HashSet<Integer> seen = new HashSet<>();
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            while (size-- > 0) {
                Integer curr = queue.poll();
                seen.add(curr);
                Set<Integer> stations = r2s.get(curr);
                if (stations.contains(target)) {
                    return count;
                }
                for (Integer station : stations) {
                    Set<Integer> rs = s2r.get(station);
                    for (Integer r : rs) {
                        //当前车做过不再做
                        if (seen.contains(r)) {
                            continue;
                        }
                        queue.offer(r);
                    }
                }
            }
        }
        return -1;
    }

    public int numBusesToDestination2(int[][] routes, int source, int target) {
        //找到路线所能到达的最远车站
        int maxPlace  = 0;
        for(int[] route : routes){
            for(int num : route){
                maxPlace = Math.max(num,maxPlace);
            }
        }
        // dp[i] 到达 i 站点所需乘坐的最少公交车数量
        int[] dp = new int[maxPlace + 1];
        if(target > maxPlace) {
            return -1;
        }
        //maxPlace + 1 代表一个永远达不到的地点
        Arrays.fill(dp,maxPlace + 1);
        dp[source] = 0;
        boolean flag = true;
        while(flag){
            for(int[] route : routes){
                int min = maxPlace + 1;
                for(int num : route){
                    if(dp[num] < min){
                        min = dp[num];
                    }
                }
                for(int num : route){
                    if(dp[num] > min + 1){      //注意一定是其他站点大于最小站点，进行交换
                        dp[num] = min + 1;      //意思就是说这个到这个车其他站点，乘坐最少为，到这个车次最少的一个加上1
                        flag = false;
                    }
                }
            }
            flag = !flag;
        }
        if(dp[target] < maxPlace + 1){
            return dp[target];
        }
        return -1;
    }
}
