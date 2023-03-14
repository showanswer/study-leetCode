package primaryAlgorithms.string;

/**
 * @author answer
 * @Description: <p>移动零</p>
 * @date 2023/3/14 20:49
 */
public class MoveZeroes {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * @param args
     */
    public static void main(String[] args) {
        MoveZeroes test = new MoveZeroes();
        int[] nums = {0,1,0,3,12};
        test.moveZeroes(nums);
    }

    /**
     * nums = [0,1,0,3,12] => [1,3,12,0,0];
     * nums = [0] => [0]
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int count =0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }
        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println("***");
    }

}
