package questionBank;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * E0242_IsAnagram
 * 有效的字母异位词
 * </p>
 *
 * @author answer
 * @date 2023/8/13 11:58
 */
public class E0242_IsAnagram {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     * @param args
     */
    public static void main(String[] args) {
        E0242_IsAnagram test = new E0242_IsAnagram();
        System.out.println(test.isAnagram("anagram", "nagaran"));
    }

    /**
     * 思路： 出现的次数相同即可，不需要看位置
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int s1 = s.length();
        int t1 = t.length();
        if (s1 != t1) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s1; i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0)+1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),0)+1);
        }
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            Character key = entry.getKey();
            if (!entry.getValue().equals(tMap.get(key))) {
                return false;
            }
        }
        return true;
    }

}
