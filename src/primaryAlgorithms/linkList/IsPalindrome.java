package primaryAlgorithms.linkList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author answer
 * @Description: <p>回文链表</p>
 * @date 2022/12/23 12:28
 */
public class IsPalindrome {

    /**
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     *
     * @param args
     */
    public static void main(String[] args) {
        IsPalindrome test = new IsPalindrome();
        ListNode node = new ListNode(1);
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(1);
        node.next = listNode;
        listNode.next = listNode1;
        listNode1.next = listNode2;
        boolean flag = test.isPalindrome1(node);
        System.out.println(flag);
    }

    /**
     * 先用两个指针找到中间节点， 在对这个中间节点后面的元素进行数据反转， 。 然后再进行比较， 头节点喝中间节点开始比较
     *
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        ListNode fast = head, slow = head;
        //通过快慢指针找到中点. 快的到最后， 慢的则刚到中间
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果fast不为空，说明链表的长度是奇数个
        if (fast != null) {
            slow = slow.next;
        }
        //反转后半部分链表
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            //然后比较，判断节点值是否相等
            if (fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }


    /**
     * @param head
     * @return 反转链表
     */
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * head = [1,2,2,1]=> true; head = [1,2]=> false
     *
     * @param head
     * @return 思路： 先遍历节点， 数据存到list中。 然后遍历list
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        if (list.size() > 0) {
            int len = list.size();
            for (int i = 0; i < len / 2; i++) {
                if (!list.get(i).equals(list.get(len - i - 1))) {
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
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
