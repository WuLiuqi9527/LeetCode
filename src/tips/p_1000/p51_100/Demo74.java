package tips.p_1000.p51_100;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 * @author hc
 */
public class Demo74 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int cowLen = matrix.length;
        if (cowLen == 0) {
            return false;
        }
        int rolLen = matrix[0].length;

        // 二分查找 二维有序数组 看成一维
        int mid, midElement;
        int left = 0, right = cowLen * rolLen - 1;

        while (left <= right) {
            mid = left + ((right - left) >> 1);
            midElement = matrix[mid / rolLen][mid % rolLen];
            if (target == midElement) {
                return true;
            } else {
                if (target < midElement) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Demo74().searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        System.out.println(new Demo74().searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
        System.out.println(new Demo74().searchMatrix(new int[][]{{1}, {3}}, 3));
        System.out.println(new Demo74().searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 11));
    }
}
