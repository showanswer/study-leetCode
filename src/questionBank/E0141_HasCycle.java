package questionBank;

import java.util.HashSet;

/**
 * <p>
 * E0141_HasCycle
 * 环形链表
 * </p>
 *
 * @author answer
 * @date 2023/6/5 22:07
 */
public class E0141_HasCycle {

    public static void main(String[] args) {
        E0141_HasCycle test = new E0141_HasCycle();
        ListNode node = new ListNode(3);
        System.out.println(test.hasCycle(node));
    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

}
