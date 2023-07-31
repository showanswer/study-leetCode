package primaryAlgorithms.string;

/**
 * @author answer
 * @Description: <p>翻转字符串里的单词</p>
 * @date 2023/2/27 22:06
 */
public class ReverseWords {

    /**
     * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     *
     * @param args
     */
    public static void main(String[] args) {
        ReverseWords test = new ReverseWords();
        String res = test.reverseWords("the  sky is blue");
        System.out.println(res);
    }

    /**
     * s = "the sky is blue" => "blue is sky the"
     * s = "  hello world  " => "world hello"
     * s = "a good   example" => "example good a"
     *
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        String[] wordArray = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int len = wordArray.length;
        while (len-- > 0) {
            if (!wordArray[len].isEmpty()) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(wordArray[len]);
            }
        }
        return sb.toString();
    }

    public String reverseWords(String s) {
        String[] wordArray = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        int len = wordArray.length;
        // len-- 先执行表达式后赋值
        // --len 先赋值后执行表达式
        while (len-- > 0) {
            if (!wordArray[len].isEmpty()) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(" ");
                }
                stringBuffer.append(wordArray[len]);
            }
        }
        return stringBuffer.toString();
    }

}
