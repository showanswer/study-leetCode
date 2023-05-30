package middleAlgorithms.arrayAndString.backtrack;

/**
 * <p>
 * SearchRange
 * </p>
 *
 * @author answer
 * @date 2023/4/17 22:52
 */
public class SearchRange {

    public static void main(String[] args) {
        SearchRange test = new SearchRange();
        int[] nums ={5,7,7,8,8,10};
        test.searchRange(nums, 8);
    }

    /**
     * nums = [5,7,7,8,8,10], target = 8 => [3,4]
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return new int[]{-1, -1};
        }

        int p =0;
        int q =nums.length -1;
        while (p <= q) {
            while (p<=q && nums[p] != target) {
                ++p;
            }
            while (p <= q && nums[q] != target) {
                --q;
            }
            if (p <= q) {
                return new int[]{p, q};
            }
        }
        return new int[]{-1, -1};
    }

}
