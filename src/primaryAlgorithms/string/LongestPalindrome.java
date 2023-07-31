package primaryAlgorithms.string;

/**
 * @author answer
 * @Description: <p>最长回文子串</p>
 * @date 2023/2/27 12:18
 */
public class LongestPalindrome {

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     *
     * @param args
     */
    public static void main(String[] args) {
        LongestPalindrome test = new LongestPalindrome();
        String res = test.longestPalindrome("babad");
        System.out.println(res);
    }

    /**
     * s = "babad" => "bab"; s = "cbbd"=> "bb"
     *
     * @param s
     * @return 思路： 最长回文串，正反序都相同的字符。 前后字符比较， 相同就继续比较。 不同就正序字符+1，继续从尾部开始比较
     * <p>
     * 回文串:正读和反读都一样的字符串(可以理解为对称的字符串)
     * 思路: 1 分为奇数串('aba')和偶数串(’abba‘)两种情况
     * 2 把每个字符当做回文串中间的字符，由内向外延展比较
     * (定义由内向外的两个索引值)
     */
    public String longestPalindrome1(String s) {
        //用数组分别记录长度，起点，终点
        int[] res = new int[3];
        for (int i = 0; i < s.length(); i++) {
            int begin = i;
            int end = i;
            //奇数回文串，直接开始中心回文。
            while (begin - 1 > 0 && end + 1 < s.length() && s.charAt(begin - 1) == s.charAt(end + 1)) {
                begin++;
                end--;
                if (end - begin > res[0]) {
                    res[0] = end - begin;
                    res[1] = begin;
                    res[2] = end;
                }
            }
            begin = i;
            end = i + 1;
            while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
                if (end - begin > res[0]) {
                    res[0] = end - begin;
                    res[1] = begin;
                    res[2] = end;
                }
                end++;
                begin--;
            }
        }
        return s.substring(res[1], res[2] + 1);
    }

    public String longestPalindrome(String s) {
        //用数组分别记录长度，起点，终点
        int[] res = new int[3];
        //每一次循环都将当前的坐标，作为回文的中心点，分为偶数和奇数中心，记录长度最长的。
        for (int i = 0; i < s.length(); i++) {
            int begin = i;
            int end = i;
            //奇数回文串，直接开始中心回文。
            while (begin - 1 >= 0 && end + 1 < s.length() && s.charAt(begin - 1) == s.charAt(end + 1)) {
                end++;
                begin--;
                //比已知最长的长度长，则记录数据
                if (end - begin > res[0]) {
                    res[0] = end - begin;
                    res[1] = begin;
                    res[2] = end;
                }
            }
            //偶数回文串，第一次先判断和下一个是否相等，然后中心回文
            begin = i;
            end = i + 1;
            while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
                if (end - begin > res[0]) {
                    res[0] = end - begin;
                    res[1] = begin;
                    res[2] = end;
                }
                end++;
                begin--;
            }
        }
        return s.substring(res[1], res[2] + 1);
    }

}
