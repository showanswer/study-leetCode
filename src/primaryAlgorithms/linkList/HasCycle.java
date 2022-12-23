package primaryAlgorithms.linkList;

/**
 * @author answer
 * @Description: <p>环形链表</p>
 * @date 2022/12/23 13:35
 */
public class HasCycle {

    /**
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
     * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
     * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
     *
     * @param args
     */
    public static void main(String[] args) {
        HasCycle test = new HasCycle();
        ListNode node = new ListNode(3);
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(4);
        node.next = listNode;
        listNode.next = listNode1;
        listNode1.next = listNode2;

        boolean flag = test.hasCycle(node);
        System.out.println(flag);
    }

    /**
     * head = [3,2,0,-4], pos = 1 => true; head = [1,2], pos = 0=> true; head = [1], pos = -1=>false
     *
     * @param head
     * @return
     * 判断链表是否有环应该是老生常谈的一个话题了，最简单的一种方式就是快慢指针，慢指针针每次走一步，快指针每次走两步，
     * 如果相遇就说明有环，如果有一个为空说明没有环。
     */
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 快的肯定先走完
        while (fast != null && fast.next != null) {
            //慢指针每次走一步
            slow = slow.next;
            //快指针每次走两步
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        //否则就是没环
        return false;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    };


}
