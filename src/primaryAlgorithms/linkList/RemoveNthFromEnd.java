package primaryAlgorithms.linkList;

import org.omg.CORBA.INTERNAL;

/**
 * @author answer
 * @Description: <p>删除链表的倒数第N个节点</p>
 * @date 2022/12/22 16:27
 */
public class RemoveNthFromEnd {

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     * @param args
     */
    public static void main(String[] args) {
        RemoveNthFromEnd test = new RemoveNthFromEnd();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode.next = listNode1;
        test.removeNthFromEnd(listNode, 1);
    }

    /**
     * head = [1,2,3,4,5], n = 2 => [1,2,3,5]; head = [1], n = 1=> []; head = [1,2], n = 1=> [1]
     *
     * @param head
     * @param n
     * @return 思路： 传递的是头节点， 先获取整个链表的长度。这样可以知道倒数第二个节点了， 然后进行删除
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        // 获取尾节点
        int len = length(head) - n;
        // 如果为0 那就是头节点。 删除头节点拿下一个节点就是新的头节点
        if (len == 0) {
            return head.next;
        }
        // 找到删除前一个节点
        for (int i = 0; i < len - 1; i++) {
            pre = pre.next;
        }
        //然后让前一个结点的next指向要删除节点的next
        pre.next = pre.next.next;
        return head;
    }

    /**
     * 获取链表长度
     *
     * @param head
     * @return
     */
    private int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
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
