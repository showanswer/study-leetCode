package primaryAlgorithms.DoublePointer;

/**
 * @author answer
 * @Description: <p>最大连续1的个数</p>
 * @date 2023/3/1 22:06
 */
public class FindMaxConsecutiveOnes {

    /**
     * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
     *
     * @param args
     */
    public static void main(String[] args) {
        FindMaxConsecutiveOnes test = new FindMaxConsecutiveOnes();
        int[] nums = {1, 0, 1, 1, 0};
        System.out.println(test.findMaxConsecutiveOnes(nums));
    }

    /**
     * nums = [1,1,0,1,1,1] => 3
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                temp++;
            } else {
                temp = 0;
            }
            max = Math.max(max, temp);
        }
        return max;
    }

}
