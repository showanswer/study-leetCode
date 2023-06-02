package questionBank;

/**
 * <p>
 * E0121_MaxProfit
 * </p>
 *
 * @author answer
 * @date 2023/6/2 23:17
 */
public class E0121_MaxProfit {

    public static void main(String[] args) {
        E0121_MaxProfit test = new E0121_MaxProfit();
        int[] nums = {7,1,5,3,6,4};
        System.out.println(test.maxProfit(nums));
    }

    public int maxProfit(int[] prices) {
        int maxProfits = 0;
        int minProfits = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minProfits) {
                minProfits = prices[i];
            } else if (maxProfits < prices[i] - minProfits) {
                maxProfits = prices[i] - minProfits;
            }
        }
        return maxProfits;
    }


}
