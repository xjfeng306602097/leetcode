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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            // 找出比下一个大的值，找到之后，去头
            if (head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            // 从dummy开始遍历，判断是否有大于的，替换
            pre = dummy;
            while (pre.next.val < head.next.val) {
                pre = pre.next;
            }
            // 找到pre链中比head.next大的值
            ListNode temp = head.next;
            head.next = temp.next; // 下次从temp开始遍历
            temp.next = pre.next;
            pre.next = temp;
        }
        return null;
    }

    public static void main(String[] args) {
    }
}
