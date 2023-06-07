package questionBank;

import java.util.HashSet;

/**
 * <p>
 * E0160_GetIntersectionNode
 * 相交链表
 * </p>
 *
 * @author answer
 * @date 2023/6/5 22:33
 */
public class E0160_GetIntersectionNode {

    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     * @param args
     */
    public static void main(String[] args) {
        E0160_GetIntersectionNode test = new E0160_GetIntersectionNode();
        System.out.println(test.getIntersectionNode(null, null));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }


}
