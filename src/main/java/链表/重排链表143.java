package 链表;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: admin
 * @date: 2020/11/24 9:57
 * @description:
 */
public class 重排链表143 {

    public void reorderList(ListNode head) {
        /**
         * 思路:
         * 1.先找到对应的中点节点，拆分出两个链表
         * 1->2->3->4->5->6
         * 1->2->3
         * 4->5->6
         * 2.反转第二个链表
         * 6->5->4
         * 3.合并两个链表
         * 1->6->2->5->3->4
         */
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 得到中点,保存
        ListNode newHead = slow.next;
        slow.next = null;

        // 倒序链表,进行反转
        newHead = reverseListNode(newHead);

        // 合并链表
        while (newHead != null) {
            ListNode next = newHead.next;
            newHead.next = head.next;
            head.next = next;
            head = newHead.next;
            newHead = next;
        }

        /*List<ListNode> list = new ArrayList<ListNode>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int i = 0;
        int j = list.size() - 1;
        // 分别从头、尾获取对应的节点
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;*/
    }

    /**
     *
     * @param head
     */
    private ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
