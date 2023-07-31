package questionBank;

import middleAlgorithms.arrayAndString.AddTwoNumbers;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 删除排序链表中的重复元素
 * </p>
 *
 * @author answer
 * @date 2023/5/30 14:57
 */
public class E0083_DeleteDuplicates {

    public static void main(String[] args) {
        E0083_DeleteDuplicates test = new E0083_DeleteDuplicates();
        AddTwoNumbers.ListNode node1 = new AddTwoNumbers.ListNode(1);
        AddTwoNumbers.ListNode node2 = new AddTwoNumbers.ListNode(1);
        AddTwoNumbers.ListNode node3 = new AddTwoNumbers.ListNode(2);
        node1.next = node2;
        node2.next = node3;
        test.deleteDuplicates(node1);
    }

    public AddTwoNumbers.ListNode deleteDuplicates(AddTwoNumbers.ListNode head) {
        AddTwoNumbers.ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 删除链表种的重复元素。 首先这里是已经排序好了的，从大到小， 重复元素 也就是相邻的元素可能重复，
     * 只需相邻元素值进行比较即可
     *
     * @param head
     * @return
     */
    public AddTwoNumbers.ListNode deleteDuplicates1(AddTwoNumbers.ListNode head) {
        AddTwoNumbers.ListNode pre = head;
        while (pre != null && pre.next != null) {
            if (pre.val == head.next.val) {
                pre.next = head.next.next;
            } else {
                pre.next = head.next;
            }
            pre = pre.next;
        }
        return head;
    }

}
