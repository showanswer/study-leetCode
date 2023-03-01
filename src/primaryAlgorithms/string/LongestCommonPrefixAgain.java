package primaryAlgorithms.string;

/**
 * @author answer
 * @Description: <p>最长公共前缀</p>
 * @date 2023/2/27 11:58
 */
public class LongestCommonPrefixAgain {

    public static void main(String[] args) {
        LongestCommonPrefixAgain test = new LongestCommonPrefixAgain();
        String[] strs = {"flower","flow","flight"};
        test.longestCommonPrefix(strs);
    }

    /**
     * strs = ["dog","racecar","car"] =>"";
     * strs = ["flower","flow","flight"] => "fl"
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs ==null || strs.length ==0) {
            return "";
        }
        String pre = strs[0];
        int idx =1;
        while (idx < strs.length) {
            while (strs[idx].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length()-1);
            }
            idx++;
        }
        return pre;
    }

}
