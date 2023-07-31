package questionBank;

/**
 * <p>
 * E0006_Convert
 * N 字形变换
 * </p>
 *
 * @author answer
 * @date 2023/6/11 19:07
 */
public class E0006_Convert {

    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     *
     * @param args
     */
    public static void main(String[] args) {
        E0006_Convert test = new E0006_Convert();
        System.out.println(test.convert("PAYPALISHIRING", 3));
    }

    /**
     * s = "PAYPALISHIRING", numRows = 3 => "PAHNAPLSIIGYIR"
     * 思路：
     */
    public String convert(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        StringBuilder[] mat = new StringBuilder[r];
        for (int i = 0; i < r; i++) {
            mat[i] = new StringBuilder();
        }
        for (int i = 0, x = 0, t = r * 2 - 2; i < n; ++i) {
            mat[x].append(s.charAt(i));
            if (i % t < r - 1) {
                ++x;
            } else {
                --x;
            }
        }
        StringBuffer ans = new StringBuffer();
        for (StringBuilder row : mat) {
            ans.append(row);
        }
        return ans.toString();

    }

}
