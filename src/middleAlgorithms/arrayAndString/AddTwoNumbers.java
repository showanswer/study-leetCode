package middleAlgorithms.arrayAndString;

/**
 * @author answer
 * @Description: <p>两数相加</p>
 * @date 2023/4/2 17:53
 */
public class AddTwoNumbers {

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
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * @param args
     */
    public static void main(String[] args) {
        AddTwoNumbers test = new AddTwoNumbers();
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        test.addTwoNumbers(node1, node4);
    }

    /**
     * l1 = [2,4,3], l2 = [5,6,4] => [7,0,8];
     * l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] => [8,9,9,9,0,0,0,1]
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode preNode = dummyNode;
        //表示两个节点相加进位的值，加法最多只进一位，所以carry要么是1要么是0
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            //当前节点的累加值，需要加上前面进位的值
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            //创建新的节点，preNode的next指针指向新的节点，因为链表节点
            //只能存储一位数字，所以这里要对sum求余，取个位数。
            preNode.next = new ListNode(sum % 10);
            // 如果sum大于等于10，说明有进位，carry为1，否则没有，carry为0
            carry = sum / 10;
            preNode = preNode.next;
        }
        return dummyNode.next;
    }

}
