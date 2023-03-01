package primaryAlgorithms.DoublePointer;

/**
 * @author answer
 * @Description: <p>反转字符串</p>
 * @date 2023/3/1 14:34
 */
public class ReverseString {

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     * @param args
     */
    public static void main(String[] args) {
        ReverseString test = new ReverseString();
        char[] s = {'h','e','l','l','o'};
        test.reverseString(s);
    }

    /**
     * s = ["h","e","l","l","o"] => ["o","l","l","e","h"]
     * @param s
     */
    public void reverseString(char[] s) {
        int length = s.length;
        for (int i = 0; i < length/2; i++) {
            char tmp = s[i];
            s[i] = s[length-i-1];
            s[length-i-1] = tmp;
        }
        System.out.println("***");
    }

}
