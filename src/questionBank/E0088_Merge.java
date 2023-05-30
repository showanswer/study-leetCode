package questionBank;

import java.util.Arrays;

/**
 * <p>
 * E0088_Merge
 * </p>
 *
 * @author answer
 * @date 2023/5/30 15:35
 */
public class E0088_Merge {

    /**
     * 合并两个有序数组
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * @param args
     */
    public static void main(String[] args) {
        E0088_Merge test = new E0088_Merge();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        test.merge(nums1, 3, nums2,3);
    }

    /**
     *  合并两个有序数组：
     *  1：将nums2的数组 合并到nums1数组中， nums1数组的容量刚好是 m+n
     *  2：双指针遍历：  然后比较大小，从后往前遍历， 填充数组1 的值
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int end = m + n -1;
        while (j >= 0) {
            if (i >=0 && nums1[i] > nums2[j]) {
                nums1[end--] = nums1[i--];
            } else {
                nums1[end--] = nums2[j--];
            }
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0; i < nums1.length; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
