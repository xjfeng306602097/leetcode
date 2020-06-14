package 链表;

public class 分隔链表86 {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy1 = new ListNode(0);
        ListNode node1 = dummy1;
        ListNode dummy2 = new ListNode(0);
        ListNode node2 = dummy2;
        while (head != null) {
            ListNode cur = head;
            if (cur.val < x) {
                node1.next = cur;
                node1 = node1.next;
            } else {
                node2.next = cur;
                node2 = node2.next;
            }
            head = head.next;
        }
        // 接链
        node1.next = dummy2.next;
        node2.next = null;
        return dummy1.next;
    }

}
