package primaryAlgorithms.array;

/**
 * @author answer
 * @Description: <p>合并两个有序数组</p>
 * @date 2023/3/19 22:38
 */
public class Merge1 {

    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     * @param args
     */
    public static void main(String[] args) {
        Merge1 test = new Merge1();
        int[] nums = {1,2,3,0,0,0};
        int[] nums1 = {2,5,6};
        test.merge(nums, 3, nums1, 3);
    }

    /**
     *  nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 =>[1,2,2,3,5,6]
     *  nums1 = [1], m = 1, nums2 = [], n = 0  => [1]
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m -1;
        int j = n -1;
        int end = m + n -1;
        while (j >=0){
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[end--] = nums1[i--];
            } else {
                nums1[end--] = nums2[j--];
            }
        }
    }
}
