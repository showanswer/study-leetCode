package primaryAlgorithms.dynamicProgramming;

/**
 * @author answer
 * @Description: <p>最大子序和</p>
 * @date 2023/1/11 14:55
 */
public class MaxSubArray {

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组 是数组中的一个连续部分。
     *
     * @param args
     */
    public static void main(String[] args) {
        MaxSubArray test = new MaxSubArray();
        int[] nums = {5, 4, -1, 7, 8};
        int res = test.maxSubArray1(nums);
        System.out.println(res);
    }

    /**
     * nums = [-2,1,-3,4,-1,2,1,-5,4] => 6; nums = [1]=> 1; nums = [5,4,-1,7,8]=> 23
     *
     * @param nums
     * @return 思路：动态规划
     * 1. 需要先确立状态（dp[]数列来储存结果，定义dp[i]表示数组中下标i为右端点的连续子数组的最大和），
     * 2. 确定方程 （从头到尾进行遍历，最后得最大值就是 dp[i-1]得值 ，加上 nums[i-1].  dp[i-1] 值大于0 就保留，小于0就舍弃）
     * 3. 初始条件和边界条件 （ 边界条件判断，当i等于0的时候，也就是前1个元素，他能构成的最大和也就是他自己）
     * 拿一个变量 记录最大值
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        //边界条件
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            // 确定方程
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            //记录最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 代码优化： 上面我们申请了一个长度为length得数组， 但是我们使用得时候 只需要用当前数组得前一个值，在之前得 都不需要。
     * 可以用一个变量 存储上一次计算完得结果
     *
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        // 临时变量 存储每次计算得结果
        int tmp = nums[0];
        int res = tmp;
        int max = tmp;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(tmp, 0) + nums[i];
            max = Math.max(max, res);
            tmp = res;
        }
        return max;
    }
}
