package 链表;

import java.util.List;

/**
 * 描述: 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaojunfeng
 * @date 2020/5/27 11:36
 **/
public class 两两交换链表中的节点24 {

    public static ListNode swapPairs(ListNode head) {
        // 递归做法 时间复杂度O(n)，空间复杂度O(n)
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        head.next = swapPairs(node.next);
        node.next = head;
        return node;
    }

    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 虚拟头节点，避免边界问题 时间复杂度O(n)，空间复杂度O(n)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 临时节点变量，用来遍历的时候指向下一个起始节点
        ListNode node = dummy;
        while (node.next != null && node.next.next != null) {
            ListNode firstNode = node.next;
            ListNode secondNode = node.next.next;
            // 交换
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            node.next = secondNode;
            // 遍历下一个节点
            node = firstNode;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node = swapPairs2(node);
        System.out.println(node.toString());
    }

}
