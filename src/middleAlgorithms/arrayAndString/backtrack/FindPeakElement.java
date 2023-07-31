package middleAlgorithms.arrayAndString.backtrack;

/**
 * <p>
 * FindPeakElement
 * </p>
 *
 * @author answer
 * @date 2023/4/17 21:12
 */
public class FindPeakElement {

    public static void main(String[] args) {
        FindPeakElement test = new FindPeakElement();
        int[] nums = {1, 2, 3, 1};
        System.out.println(test.findPeakElement(nums));
    }

    /**
     * nums = [1,2,3,1] = >2
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] < nums[i]) {
                continue;
            }
            if (i < nums.length - 1 && nums[i + 1] > nums[i]) {
                continue;
            }
            return i;
        }
        return -1;

    }

}
