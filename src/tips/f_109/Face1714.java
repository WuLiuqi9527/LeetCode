package tips.f_109;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * <p>示例：
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * <p>提示：
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 *
 * @author hc
 */
public class Face1714 {

    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int a : arr) {
            queue.add(a);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public int[] smallestK2(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        new Face1714().smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4);
    }
}
