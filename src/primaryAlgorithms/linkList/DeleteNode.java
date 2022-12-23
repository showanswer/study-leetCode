package primaryAlgorithms.linkList;

/**
 * @author answer
 * @Description: <p>删除链表中的节点</p>
 * @date 2022/12/22 16:06
 */
public class DeleteNode {
    /**
     * 有一个单链表的 head，我们想删除它其中的一个节点 node。给你一个需要删除的节点 node 。你将 无法访问 第一个节点  head。
     * 链表的所有值都是 唯一的，并且保证给定的节点 node 不是链表中的最后一个节点。删除给定的节点。注意，删除节点并不是指从内存中删除它。
     * 这里的意思是：给定节点的值不应该存在于链表中。链表中的节点数应该减少 1。
     *
     * node 前面的所有值顺序相同。
     * node 后面的所有值顺序相同。
     *
     * @param args
     */
    public static void main(String[] args) {
        DeleteNode test = new DeleteNode();
        ListNode node = new ListNode(4);
        ListNode listNode = new ListNode(5);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(9);
        node.next = listNode;
        listNode.next = listNode1;
        listNode1.next = listNode2;
        test.deleteNode(listNode);
    }

    /**
     * head = [4,5,1,9], node = 5 =》 [4,1,9]； head = [4,5,1,9], node = 1=》[4,5,9]
     * @param node
     *
     * 自定义测试：
     * 对于输入，你应该提供整个链表 head 和要给出的节点 node。node 不应该是链表的最后一个节点，而应该是链表中的一个实际节点。
     * 我们将构建链表，并将节点传递给你的函数。
     * 输出将是调用你函数后的整个链表。
     *
     *  思路： 把该节点变为他的下驱节点
     */
    public void deleteNode(ListNode node) {
        // 先改变值， 不然节点变后但是值也变了
        node.val = node.next.val;
        node.next = node.next.next;
    }


    /**
     * 链表节点
     */
    public static class ListNode {
        // 节点值
        int val;
        // 节点下驱
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
