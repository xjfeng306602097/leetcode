package 链表;

/**
 * @author: admin
 * @date: 2020/11/23 17:17
 * @description:
 */
public class 移除链表元素203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode temp = pre.next;
        while (temp.next != null) {
            if (pre.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return pre.next;
    }

}
