package questionBank;

/**
 * <p>
 * E0171_TitleToNumber
 * </p>
 *
 * @author answer
 * @date 2023/6/7 22:06
 */
public class E0171_TitleToNumber {

    public static void main(String[] args) {
        E0171_TitleToNumber test = new E0171_TitleToNumber();
        System.out.println(test.titleToNumber("AB"));
    }

    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return ans;
    }

}
