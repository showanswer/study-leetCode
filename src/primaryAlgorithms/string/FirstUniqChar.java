package primaryAlgorithms.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author answer
 * @Description: <p>字符串中的第一个唯一字符</p>
 * @date 2022/12/20 11:44
 */
public class FirstUniqChar {

    /**
     * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
     * 思路：先统计每个字符的数量，然后在查找
     *
     * @param args
     */
    public static void main(String[] args) {
        FirstUniqChar test = new FirstUniqChar();
        int res = test.firstUniqChar2("dddccdbba");
        System.out.println(res);
    }

    /**
     * s = "leetcode" =>0, s = "loveleetcode"=>2, s = "aabb"=>-1, "dddccdbba"=>8
     *
     * @param s
     * @return 思路2：使用hash， key为字符，value为次数。
     */
    public int firstUniqChar(String s) {
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }

        for (int i = 0; i < length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 思路： 两次遍历，先统计每个字符出现的次数。第二遍再次从前往后遍历字符串s中的每个字符，如果某个字符出现一次直接返回
     *
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        // 26个字母 统计 同字符累加
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            count[chars[i] - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * s = "leetcode" =>0, s = "loveleetcode"=>2, s = "aabb"=>-1, "dddccdbba"=>8
     *
     * @param s
     * @return 思路1： set, 把元素存进set集合， 如果后面有重复的， 就去除该元素，并记录该元素为重复元素后面的不再添加
     * 缺陷： set无序的， 无法返回第一个不重复的元素。只适合 查询唯一不重复的元素的索引。
     * 解决： 遍历字符s, 如果s中的字符在集合set中， 直接返回该元素的索引
     */
    public int firstUniqChar1(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            String str = sb.toString();
            Boolean remFlag = false;
            if (!str.contains(String.valueOf(chars[i]))) {
                sb.append(chars[i]);
                remFlag = true;
            }
            // 如果sb 里有该字符了， set集合里没有。 就说明删除过元素就不再重复添加
            if (remFlag) {
                // 新元素第一次出现直接添加进set
                set.add(chars[i]);
            } else {
                // 不是就直接删除
                set.remove(chars[i]);
            }
        }
        if (set.size() > 0) {
            for (int i = 0; i < chars.length; i++) {
                // "dddccdbba"=>8  缺陷： 前面几个字符重复， 返回值错误。 set无法实现
                if (!set.add(chars[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

}
