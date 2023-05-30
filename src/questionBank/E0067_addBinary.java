package questionBank;

import javax.crypto.Mac;

/**
 * <p>
 * E0067_addBinary
 * </p>
 *
 * @author answer
 * @date 2023/4/27 19:28
 */
public class E0067_addBinary {

    public static void main(String[] args) {
        E0067_addBinary test = new E0067_addBinary();
        System.out.println(test.addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 -i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - i -1) - '0') : 0;
            sb.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            sb.append('1');
        }
        sb.reverse();
        return sb.toString();
    }

    public String addBinary1(String a, String b) {
        int anInt = Integer.parseInt(a, 2);
        int anInt1 = Integer.parseInt(b, 2);
        return Integer.toBinaryString(anInt + anInt1);
    }

}
