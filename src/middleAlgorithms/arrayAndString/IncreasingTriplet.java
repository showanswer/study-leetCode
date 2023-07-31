package middleAlgorithms.arrayAndString;

/**
 * @author answer
 * @Description: <p>IncreasingTriplet</p>
 * @date 2023/4/1 12:08
 */
public class IncreasingTriplet {

    public static void main(String[] args) {
        IncreasingTriplet test = new IncreasingTriplet();
        int[] nums = {2, 1, 5, 0, 4, 6};
        System.out.println(test.increasingTriplet(nums));
    }

    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= small) {
                small = nums[i];
            } else if (nums[i] <= middle) {
                middle = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }

}
