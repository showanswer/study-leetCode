package primaryAlgorithms.linkList;

import java.util.Stack;

/**
 * @author answer
 * @Description: <p>反转链表</p>
 * @date 2022/12/22 17:05
 */
public class ReverseList {

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     *
     * @param args
     */
    public static void main(String[] args) {
        ReverseList test = new ReverseList();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        test.reverseList(listNode);
    }

    /**
     * head = [1,2,3,4,5] => [5,4,3,2,1]; head = [1,2]=> [2,1]; head = []=> []
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()) {
            return null;
        }
        ListNode listNode = stack.pop();
        ListNode temp = listNode;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            listNode.next = node;
            listNode = listNode.next;
        }
        listNode.next = null;
        return temp;
    }

    public ListNode reverseList1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        if (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()) {
            return null;
        }
        // 这个是尾节点, 新的头节点
        ListNode node = stack.pop();
        // 临时存储头节点， 用于返回
        ListNode dummy = node;
        while (!stack.isEmpty()) {
            ListNode tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }
        //最后一个结点就是反转前的头结点，一定要让他的next. 等于空，否则会构成环
        node.next = null;
        return dummy;
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
