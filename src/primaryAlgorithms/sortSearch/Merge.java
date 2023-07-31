package primaryAlgorithms.sortSearch;

/**
 * @author answer
 * @Description: <p>合并两个有序数组</p>
 * @date 2023/1/2 21:22
 */
public class Merge {


    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
     * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     *
     * @param args
     */
    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge.merge(nums1, 3, nums2, 3);
    }

    /**
     * nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 =>[1,2,2,3,5,6]
     * nums1 = [1], m = 1, nums2 = [], n = 0 => [1]
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int index = 0;
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[index++] = nums1[i++];
            } else {
                temp[index++] = nums2[j++];
            }
        }

        for (; i < m; ) {
            temp[index++] = nums1[i++];
        }
        for (; j < n; ) {
            temp[index++] = nums2[j++];
        }
        //再把数组temp中的值赋给nums1
        for (int k = 0; k < m + n; k++) {
            nums1[k] = temp[k];
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int end = m + n - 1;
        while (j >= 0) {
            nums1[end--] = (i >= 0 && nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }
    }

}
