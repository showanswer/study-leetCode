package primaryAlgorithms.string;

/**
 * @author answer
 * @Description: <p>验证回文串</p>
 * @date 2022/12/20 20:45
 */
public class IsPalindrome {

    /**
     * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
     * 字母和数字都属于字母数字字符。给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
     *
     * @param args
     */
    public static void main(String[] args) {
        IsPalindrome test = new IsPalindrome();
        boolean flag = test.isPalindrome("race a car");
        System.out.println(flag);
    }

    /**
     * s = "A man, a plan, a canal: Panama"=>true; s = "race a car"=>false; s = " "=>true
     *
     * @param s
     * @return 思路：双指针，一个指向前，一个指向后。 遇到非数字或字符的就跳过， 否则就比较
     */
    public boolean isPalindrome1(String s) {
        int length = s.length();
        int i = 0;
        int j = length - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(chars[i])) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(chars[j])) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
