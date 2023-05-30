package questionBank;

import primaryAlgorithms.string.MaxArea;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * LengthOfLongestSubstring_003
 * </p>
 * @author answer
 * @date 2023/4/22 20:53
 */
public class LengthOfLongestSubstring_003 {

    public static void main(String[] args) {
        LengthOfLongestSubstring_003 test = new LengthOfLongestSubstring_003();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int max =0 , right=0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (i -1>= 0) {
                set.remove(s.charAt(i-1));
            }
            while (right <= length-1 && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                ++right;
            }
            max = Math.max(right-i, max);
        }
        return max;
    }

}
