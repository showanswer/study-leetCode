package primaryAlgorithms.string;

/**
 * @author answer
 * @Description: <p>最长公共前缀</p>
 * @date 2022/12/21 22:07
 */
public class LongestCommonPrefix {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * @param args
     */
    public static void main(String[] args) {
        LongestCommonPrefix test = new LongestCommonPrefix();
        String [] strings = new String[]{"flower","flow","sfolight"};
        String prefix = test.longestCommonPrefix2(strings);
        System.out.println(prefix);
    }

    /**
     * strs = ["flower","flow","flight"] => "fl"; strs = ["dog","racecar","car"] => ""
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = strs[0];
        int i=1;
        while (i<strs.length) {
            while (strs[i].indexOf(res) !=0) {
                res = res.substring(0, res.length()-1);
            }
            i++;
        }
        return res;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        int i = 1;
        // 数组截取
        while (i<strs.length) {
            // 每个字符减小 匹配
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length()-1);
            }
            i++;
        }
        return pre;
    }

    /**
     * strs = ["flower","flow","flight"] => "fl"; strs = ["dog","racecar","car"] => ""
     * @param strs
     * @return
     * 思路：
     */
    public String longestCommonPrefix1(String[] strs) {
        int length = strs.length;
        if (strs == null || length == 0) {
            return "";
        }
        String pre = strs[0];
        int i =1;
        while (i< length) {
            while (strs[i].indexOf(pre) != 0 ) {
                pre = pre.substring(0, pre.length()-1);
            }
            i++;
        }
        return pre;
    }
}
