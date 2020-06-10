package 链表;

import java.util.Stack;

/**
 * 描述: 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaojunfeng
 * @date 2020/5/27 13:05
 **/
public class 两数相加II445 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 不能翻转链表的情况下，可以考虑栈的方式，栈底放入的是链表的头节点，栈顶是链表的尾节点，由于是倒序相加，所以从栈顶开始
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode node = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = 0;
            sum += carry;
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = node;
            node = newNode;
        }
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = node;
            node = newNode;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        /*node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);
        node1.next.next.next = new ListNode(3);*/
        ListNode node2 = new ListNode(5);
        /*node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);*/
        ListNode node3 = 两数相加II445.addTwoNumbers(node1, node2);
        System.out.println(node3.toString());
    }

}
