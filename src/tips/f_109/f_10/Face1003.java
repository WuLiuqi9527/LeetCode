package tips.f_109.f_10;

/**
 * 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。
 * 请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
 * <p>示例1:
 * 输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 * 输出: 8（元素5在该数组中的索引）
 * <p>示例2:
 * 输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 * 输出：-1 （没有找到）
 * <p>提示:
 * arr 长度范围在[1, 1000000]之间
 *
 * @author hc
 */
public class Face1003 {

    public int search(int[] arr, int target) {
        // 暴力
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (target == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public int search2(int[] arr, int target) {
        // 二分
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[l] == target) {
                return l;
            }

            if (target == arr[mid]) {
                r = mid;
            } else if (arr[mid] < arr[r]) {
                if (target > arr[mid] && target <= arr[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else if (arr[mid] > arr[r]) {
                if (arr[l] <= target && target < arr[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                --r;
            }
        }
        return -1;
    }
}
