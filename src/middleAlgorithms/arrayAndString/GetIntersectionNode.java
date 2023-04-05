package middleAlgorithms.arrayAndString;

import java.util.HashSet;
import java.util.Set;

/**
 * @author answer
 * @Description: <p>相交链表</p>
 * @date 2023/4/2 18:32
 */
public class GetIntersectionNode {

    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     * @param args
     */
    public static void main(String[] args) {
        GetIntersectionNode test = new GetIntersectionNode();
        ListNode headA = new ListNode();
        ListNode headB = new ListNode();
        test.getIntersectionNode(headA, headB);
    }

    /**
     *  listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3 => intersectVal = 8
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while (headA != null){
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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
