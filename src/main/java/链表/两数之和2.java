package 链表;

import java.util.List;

/**
 * 描述: TODO
 *
 * @author xiaojunfeng
 * @date 2020/5/25 14:44
 **/
public class 两数之和2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode tmp = result;
        int sum = 0;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (carry > 0) {
                sum += carry;
            }
            carry = sum / 10;
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
            sum = 0;
        }
        if (carry > 0) {
            tmp.next = new ListNode(1);
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);
        ListNode node3 = 两数之和2.addTwoNumbers(node1, node2);
        System.out.println(node3.toString());
    }

}
