package primaryAlgorithms.string;

/**
 * @author answer
 * @Description: <p>实现 strStr</p>
 * @date 2022/12/21 20:22
 */
public class StrStr {

    /**
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
     * 如果 needle 不是 haystack 的一部分，则返回  -1 。
     *
     * @param args
     */
    public static void main(String[] args) {
        StrStr test = new StrStr();
        int num = test.strStr2("leetcode", "leeto");
        System.out.println(num);
    }

    /**
     * haystack = "sadbutsad", needle = "sad" => 0; haystack = "leetcode", needle = "leeto"=> -1
     *
     * @param haystack
     * @param needle
     * @return 思路： 双指针实现， 第一个指针遍历haystack， 第二个指针指向needle， 依次做比较，相同就都指针++， 不同就haystack指针返回之前索引的下一个
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                // 不匹配就返回
                i = i - j + 1;
                j = 0;
            }
            // 判断完成 一致返回索引
            if (j == needle.length()) {
                return i - j;
            }
        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * haystack = "sadbutsad", needle = "sad" => 0; haystack = "leetcode", needle = "leeto"=> -1
     *
     * @param haystack
     * @param needle
     * @return 思路： 双指针实现， 第一个指针遍历haystack， 第二个指针指向needle， 依次做比较，相同就都指针++， 不同就haystack指针返回之前索引的下一个
     */
    public int strStr2(String haystack, String needle) {
        if (needle.length() == 0) {
            return -1;
        }
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j == needle.length()) {
                return i - j;
            }
        }
        return -1;
    }


}
