package primaryAlgorithms.string;

/**
 * @author answer
 * @Description: <p>反转字符串</p>
 * @date 2022/12/19 21:44
 */
public class ReverseString {

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * @param args
     */
    public static void main(String[] args) {
        ReverseString test = new ReverseString();
        char[] chars = {'h','e','l','l','o'};
        test.reverseString(chars);
    }

    /**
     * s = ["h","e","l","l","o"] => ["o","l","l","e","h"]
     * s = ["H","a","n","n","a","h"] => ["h","a","n","n","a","H"]
     * @param s
     * 思路： 前后直接交换
     */
    public void reverseString2(char[] s) {
        int length = s.length;
        for (int i = 0; i < s.length/2; i++) {
            char tmp =s[i];
            s[i] = s[length-1-i];
            s[length-1-i] = tmp;
        }
    }

    public void reverseString(char[] s) {
        int length = s.length;
        for (int i = 0; i < length/2; i++) {
            char temp =s[i];
            s[i] = s[length-1-i];
            s[length-1-i] =temp;
        }
        System.out.println("***");
    }

}
