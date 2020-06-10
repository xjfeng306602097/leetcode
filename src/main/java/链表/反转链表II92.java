package 链表;

import java.util.List;

/**
 * 描述: 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaojunfeng
 * @date 2020/6/1 12:33
 **/
public class 反转链表II92 {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // 1->2->3->4->5->NULL, m = 2, n = 4 ,找到m,n位置,找到断链位置后，反转链表，反转后接链
        // 记录断链的头节点,添加头节点,避免m=1的情况下,找不到对应的其实头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode begin = null;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
            begin = pre;
        }
        // 获取截断的头节点，开始遍历下一个节点
        head = pre.next;
        int j = m;
        ListNode end = head;
        ListNode prev = null;
        while (head != null && j <= n) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
            j++;
        }
        if (begin != null) {
            begin.next = prev;
        } else {
            dummy.next = prev;
        }
        if (head != null) {
            end.next = head;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode node = reverseBetween(head, 1, 6);
        System.out.println(node.toString());
    }

}
