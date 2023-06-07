package questionBank;

/**
 * <p>
 * E0125_IsPalindrome
 * </p>
 *
 * @author answer
 * @date 2023/6/5 21:43
 */
public class E0125_IsPalindrome {

    public static void main(String[] args) {
        E0125_IsPalindrome test = new E0125_IsPalindrome();
        System.out.println(test.isPalindrome("A man, a plan, a canal: Panama"));
    }


    /**
     * 字符反转
     * @param s
     * @return
     */
    public boolean isPalindrome1(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
             if (Character.isLetterOrDigit(s.charAt(i))) {
                 sb.append(Character.toLowerCase(s.charAt(i)));
             }
        }
        StringBuilder sb1 = new StringBuilder(sb).reverse();
        return sb1.toString().equals(sb.toString());
    }

    /**
     * 双指针
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int left =0;
        int right =s.length()-1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left ++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right --;
            }
            if (Character.toLowerCase(s.charAt(left))  != Character.toLowerCase(s.charAt(right))) {
                return false;
            } else {
                left ++;
                right --;
            }
        }
        return true;
    }

}
