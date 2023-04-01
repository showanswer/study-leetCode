package middleAlgorithms.arrayAndString;

import java.util.*;

/**
 * @author answer
 * @Description: <p>GroupAnagrams</p>
 * @date 2023/3/30 22:12
 */
public class GroupAnagrams {


    public static void main(String[] args) {
        GroupAnagrams test = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(test.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String string = String.valueOf(chars);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList<String>());
            }
            map.get(string).add(str);
        }
        return new ArrayList<>(map.values());
    }

}
