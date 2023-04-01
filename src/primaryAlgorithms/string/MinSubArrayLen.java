package primaryAlgorithms.string;

/**
 * @author answer
 * @Description: <p>长度最小的子数组</p>
 * @date 2023/3/25 21:36
 */
public class MinSubArrayLen {

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
     * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
     *
     * @param args
     */
    public static void main(String[] args) {
        MinSubArrayLen test = new MinSubArrayLen();
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(test.minSubArrayLen(7, nums));
    }

    /**
     * target = 7, nums = [2,3,1,2,4,3] => 2;
     * target = 4, nums = [1,4,4] => 1;
     * target = 11, nums = [1,1,1,1,1,1,1,1] =>0;
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum+=nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right ++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen1(int target, int[] nums) {
        // 滑动窗口
        int left = 0, right = 0, sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
