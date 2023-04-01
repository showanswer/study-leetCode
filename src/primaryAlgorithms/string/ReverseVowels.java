package primaryAlgorithms.string;

/**
 * @author answer
 * @Description: <p>反转字符串中的元音字母</p>
 * @date 2023/3/22 21:25
 */
public class ReverseVowels {

    /**
     * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
     * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
     * @param args
     */
    public static void main(String[] args) {
        ReverseVowels test = new ReverseVowels();
        System.out.println(test.reverseVowels("hello"));
    }

    /**
     * s = "hello" =>"holle";  s = "leetcode"=>"leotcede"
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        int i =0;
        int j = s.length()-1;
        char[] chars = s.toCharArray();

        while (i < j) {
            while ((i<j) && !((chars[i] == 'a') || (chars[i] == 'A') || (chars[i] == 'e') ||(chars[i] == 'E') ||(chars[i] == 'i') ||(chars[i] == 'I') ||
                    (chars[i] == 'o') ||  (chars[i] == 'O') ||(chars[i] == 'u') ||(chars[i] == 'U') )) {
                i++;
            }
            while ((i<j) && !((chars[j] == 'a') || (chars[j] == 'A') || (chars[j] == 'e') ||(chars[j] == 'E') ||(chars[j] == 'i') ||(chars[j] == 'I') ||
                    (chars[j] == 'o') ||  (chars[j] == 'O') ||(chars[j] == 'u') ||(chars[j] == 'U') )) {
                j--;
            }
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;

            i++;
            j--;
        }
        return new String(chars);
    }
}
