package primaryAlgorithms.linkList;

/**
 * @author answer
 * @Description: <p>合并两个有序链表</p>
 * @date 2022/12/22 21:10
 */
public class MergeTwoLists {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * @param args
     */
    public static void main(String[] args) {
        MergeTwoLists test = new MergeTwoLists();
        ListNode listNode = new ListNode(1);
        ListNode listNodes = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNodes2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNodes3 = new ListNode(4);

        listNode.next = listNode1;
        listNode1.next = listNode3;

        listNodes.next = listNodes2;
        listNodes2.next = listNodes3;

        test.mergeTwoLists1(listNode, listNodes);
    }

    /**
     * l1 = [1,2,4], l2 = [1,3,4] => [1,1,2,3,4,4]; l1 = [], l2 = []=>[]; l1 = [], l2 = [0]=>[0]
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode(0);
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode curr = listNode;
        while (list1 != null && list2 != null) {
            // 小的 作为下一个节点。 但是另外的一个链表还是原来的节点
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        //走到这里说明至少有一个链表结束了 然后把那个不为空的链表挂到新的链表中
        curr.next = list1 == null ? list2 : list1;
        return listNode.next;
    }

    /**
     * 优化 递归实现
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists1(list1, list2.next);
            return list2;
        }
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
