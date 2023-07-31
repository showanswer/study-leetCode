package middleAlgorithms.arrayAndString;

/**
 * @author answer
 * @Description: <p>最长回文子串</p>
 * @date 2023/4/1 11:16
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome test = new LongestPalindrome();
        System.out.println(test.longestPalindrome("babad"));
    }

    /**
     * s = "babad" => "bab"
     * s = "cbbd" => "bb"
     * 思路： 最长回文子串， 返回的是字串 中心法
     * 返回字串： 索引判断是否为回文串后， 根据索引截取出字串
     * 回文可以用中心法： 把每个字符当作中心点，从而向两边遍历，是否相同， 两边遍历需要有两个遍历记录位置
     * 遍历时， 前后索引的距离就是回文串的长度， 取最大值
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int start = 0, maxLen = 0;
        int length = s.length();
        for (int i = 0; i < length; ) {
            if (length - i <= maxLen / 2) {
                break;
            }
            int left = i;
            int right = i;
            while (right < length - 1 && s.charAt(right) == s.charAt(right + 1)) {
                ++right;
            }
            i = right + 1;
            while (right < length - 1 && left > 0 && s.charAt(left - 1) == s.charAt(right + 1)) {
                ++right;
                --left;
            }
            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
            }
        }
        return s.substring(start, start + maxLen);
    }

}
