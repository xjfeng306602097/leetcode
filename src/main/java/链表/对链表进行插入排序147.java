package 链表;

import java.util.List;

/**
 * 描述: TODO
 *
 * @author xiaojunfeng
 * @date 2020/5/28 9:37
 **/
public class 对链表进行插入排序147 {

    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0 );
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            if (head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            pre = dummy;
            while (pre.next.val < head.next.val) {
                pre = pre.next;
            }
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
    }
}
