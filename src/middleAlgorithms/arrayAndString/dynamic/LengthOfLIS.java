package middleAlgorithms.arrayAndString.dynamic;

/**
 * <p>
 * 最长递增子序列
 * </p>
 *
 * @author answer
 * @date 2023/4/20 20:45
 */
public class LengthOfLIS {

    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     */
    public static void main(String[] args) {
        LengthOfLIS test = new LengthOfLIS();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(test.lengthOfLIS(nums));
    }

    /**
     * nums = [10,9,2,5,3,7,101,18]  => 4;
     * nums = [0,1,0,3,2,3] => 4;
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 1; (i - j) >= 0; j++) {
                // 不断和前面的比较，大于则取其中的最大值
                if (nums[i] > nums[i - j]) {
                    max = Math.max(dp[i - j], max);
                }
            }
            dp[i] = max + 1;
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }

}
