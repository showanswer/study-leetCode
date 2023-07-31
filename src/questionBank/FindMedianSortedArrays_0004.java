package questionBank;

/**
 * <p>
 * 寻找两个正序数组的中位数
 * </p>
 *
 * @author answer
 * @date 2023/4/24 20:18
 */
public class FindMedianSortedArrays_0004 {

    public static void main(String[] args) {
        FindMedianSortedArrays_0004 test = new FindMedianSortedArrays_0004();
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        System.out.println(test.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        // 偶数中位数， 奇数中位数右侧的数据
        int num = 0;
        boolean flag = len % 2 == 0;
        // 偶数 中位数右侧的数据， 奇数 中位数左侧的数据
        len = len / 2;

        if (len == 0) {
            return 0;
        }

        if (m == 0) {
            return flag ? (nums2[len - 1] + nums2[len]) / 2.0 : nums2[len];
        }
        if (n == 0) {
            return flag ? (nums1[len - 1] + nums1[len]) / 2.0 : nums1[len];
        }

        int i = 0, j = 0;
        int oldNum = num;
        while (i + j != len + 1) {
            oldNum = num;
            if (i >= m || (j < n && nums1[i] > nums2[j])) {
                num = nums2[j++];
            } else {
                num = nums1[i++];
            }
        }
        return flag ? (num + oldNum) / 2.0 : num;
    }

}
