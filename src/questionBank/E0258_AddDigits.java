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
     *
     * @param num
     * @return
     */
    public int addDigits(int num) {
        while (num>= 10) {
            int sum =0;
            while (num >0 ) {
                sum += sum % 10;
                num = num /10;
            }
            return sum;
        }
        return num;
    }

}
