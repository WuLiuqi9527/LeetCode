package offer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这 8 个数字，则最小的 4 个数字是 1、2、3、4。
 * <p>示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * <p>示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * @author hc
 */
public class Offer40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        // 大根堆 优先队列
        if (arr == null || k == 0) {
            return new int[0];
        }

        int[] res = new int[k];
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : arr) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (num < queue.peek()) {
                queue.poll();
                queue.add(num);
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public int[] getLeastNumbers3(int[] arr, int k) {
        // 桶思想 计数排序
        if (arr == null || k == 0) {
            return new int[0];
        }

        int[] count = new int[10001];
        for (int num : arr) {
            ++count[num];
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = 0; i < 10001; i++) {
            while (count[i]-- > 0 && index < k) {
                res[index++] = i;
            }
            if (index == k) {
                break;
            }
        }
        return res;
    }
}
