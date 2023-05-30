package questionBank;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <p>
 * IsValid_0020
 * </p>
 *
 * @author answer
 * @date 2023/4/25 19:36
 */
public class IsValid_0020 {

    public static void main(String[] args) {
        IsValid_0020 test = new IsValid_0020();
        test.isValid("()[]{}");
    }

    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 !=0) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            if (pairs.containsKey(s.charAt(i))) {
                if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

}
