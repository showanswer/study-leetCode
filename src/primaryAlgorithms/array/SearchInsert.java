package primaryAlgorithms.array;

import java.util.Arrays;

/**
 * @author answer
 * @Description: <p>SearchInsert</p>
 * @date 2023/1/29 16:04
 */
public class SearchInsert {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 请必须使用时间复杂度为 O(log n) 的算法。
     *
     * @param args 如果数组中的值大于或者等于target，直接return
     *             如果全部遍历完证明target是最大的数，直接插入末尾
     */
    public static void main(String[] args) {
        SearchInsert test = new SearchInsert();
        int[] nums = {1, 3, 5, 6};
        System.out.println(test.searchInsert1(nums, 5));
    }

    /**
     * nums = [1,3,5,6], target = 5 => 2; nums = [1,3,5,6], target=2 =>1; nums = [1,3,5,6], target = 7=>4;
     *
     * @param nums
     * @param target
     * @return 思路： 遍历数组中的元素和目标元素是否相同，并比较大小，返回索引位置
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }


    /**
     * nums = [1,3,5,6], target = 5 => 2; nums = [1,3,5,6], target=2 =>1; nums = [1,3,5,6], target = 7=>4;
     *
     * @param nums
     * @param target
     * @return 思路： 二分法
     */
    public int searchInsert1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 防止 left+right 整型溢出
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }


}
