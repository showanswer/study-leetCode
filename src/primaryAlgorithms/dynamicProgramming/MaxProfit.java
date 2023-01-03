package primaryAlgorithms.dynamicProgramming;

/**
 * @author answer
 * @Description: <p>买卖股票的最佳时机</p>
 * @date 2023/1/3 12:49
 */
public class MaxProfit {

    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
     * @param args
     */
    public static void main(String[] args) {
        MaxProfit test = new MaxProfit();
        int[] nums = {7,1,5,3,6,4};
        int maxProfit = test.maxProfit(nums);
        System.out.println(maxProfit);
    }

    /**
     * [7,1,5,3,6,4] => 5; prices = [7,6,4,3,1]=>0
     * @param prices
     * @return
     * 注意： 只能买卖一次i， 没有买之前无论是第几天收益都为0
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][2];
        //边界条件
        dp[0][0]= 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return  dp[length - 1][0];
    }

    /**
     * 计算当天的最大利润只和前一天的利润有关，所以没必要使用二维数组，
     * 只需要使用两个变量即可，一个表示当天持有股票的最大利润，一个表示当天没持有股票的最大利润
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        //持有股票
        int hold = -prices[0];
        //不持有股票
        int noHold = 0;
        for (int i = 1; i < length; i++) {
            //递推公式
            noHold = Math.max(noHold, hold + prices[i]);
            hold = Math.max(hold, -prices[i]);
        }
        //毋庸置疑，最后肯定是手里没持有股票利润才会最大，
        //也就是卖出去了
        return noHold;
    }
}
