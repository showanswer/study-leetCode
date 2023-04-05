package middleAlgorithms.arrayAndString;

/**
 * @author answer
 * @Description: <p>奇偶链表</p>
 * @date 2023/4/2 18:12
 */
public class OddEvenList {

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

    /**
     * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
     * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
     * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
     * @param args
     */
    public static void main(String[] args) {
        OddEvenList test = new OddEvenList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        test.oddEvenList(node1);
    }

    /**
     * head = [1,2,3,4,5] => [1,3,5,2,4]
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        //奇数链表的头节点
        ListNode oddHead = head;
        //奇数链表的当前节点
        ListNode oddCur = oddHead;

        //偶数链表的头节点
        ListNode evenHead = head.next;
        //偶数链表的当前节点
        ListNode evenCur = evenHead;

        while (evenCur != null && evenCur.next != null) {
            //奇数节点串一起
            oddCur.next = oddCur.next.next;
            //偶数节点串一起
            evenCur.next = evenCur.next.next;
            //奇偶指针往后移
            oddCur = oddCur.next;
            evenCur = evenCur.next;
        }
        //最后偶数链表和奇数链表需要串在一起
        oddCur.next = evenHead;
        return oddHead;
    }

}
