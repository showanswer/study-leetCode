package questionBank;

/**
 * <p>
 * E0258_AddDigits
 * 各位相加
 * </p>
 *
 * @author answer
 * @date 2023/8/14 20:16
 */
public class E0258_AddDigits {

    public static void main(String[] args) {
        E0258_AddDigits test = new E0258_AddDigits();
        System.out.println(test.addDigits(38));
    }

    /**
     * 思路： 个数相加 % 和 / 得到末尾数字，如果相加后得到的还是 >10 则再次判断进行循环则 while
     * @param num
     * @return
     *   38
     * num 个数都相加了，累加的和 还是 >10
     */
    public int addDigits(int num) {
        int sum =num;
        while (sum >= 10) {
           sum =0;
           while ( num > 0) {
               sum += num % 10;
               num = num / 10;
           }
           num = sum ;
        }
        return sum;
    }

    /**
     *
     * @param num
     * @return
     */
    public int addDigits1(int num) {
        while (num >= 10) {
            int sum =0;
            while (num >0) {
                sum += num % 10;
                num = num /10;
            }
            num = sum;
        }
        return num;
    }

}
