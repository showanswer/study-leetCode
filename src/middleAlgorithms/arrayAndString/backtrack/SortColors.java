package middleAlgorithms.arrayAndString.backtrack;

/**
 * <p>
 * SortColors
 * </p>
 *
 * @author answer
 * @date 2023/4/17 20:27
 */
public class SortColors {

    public static void main(String[] args) {
        SortColors test = new SortColors();
        int[] nums ={2,0,2,1,1,0};
        test.sortColors(nums);
    }

    /**
     *  nums = [2,0,2,1,1,0] => [0,0,1,1,2,2];
     *  nums = [2,0,1] => [0,1,2]
     * @param nums
     */
    public void sortColors(int[] nums) {
        int left =0;
        int right =nums.length -1;

        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0){
                swap(nums, left, i);
                left ++;
            }
            if (nums[i] == 2) {
                swap(nums, right, i);
                right--;
                i--;
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
