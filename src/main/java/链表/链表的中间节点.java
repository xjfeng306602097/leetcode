package 链表;

public class 链表的中间节点 {

    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int n=0;
        while(cur != null) {
            ++n;
            cur = cur.next;
        }
        int k = 0;
        cur = head;
        while (k< n/2) {
            ++k;
            cur = cur.next;
        }
        return cur.next;
    }

}
