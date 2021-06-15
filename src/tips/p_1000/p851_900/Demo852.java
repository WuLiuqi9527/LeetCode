package tips.p_1000.p851_900;

/**
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，
 * 返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 * <p>示例 1：
 * 输入：arr = [0,1,0]
 * 输出：1
 * <p>示例 2：
 * 输入：arr = [0,2,1,0]
 * 输出：1
 * <p>示例 3：
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * <p>示例 4：
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * <p>示例 5：
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 * <p>提示：
 * 3 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^6
 * 题目数据保证 arr 是一个山脉数组
 * <p>进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？
 *
 * @author hc
 */
public class Demo852 {

    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int l = 0, r = len - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (arr[mid - 1] < arr[mid]) {
                l = mid;
            } else if (arr[mid - 1] > arr[mid]) {
                r = mid;
            }
        }

        return r;
    }

    public int peakIndexInMountainArray2(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (arr[mid - 1] < arr[mid]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}
