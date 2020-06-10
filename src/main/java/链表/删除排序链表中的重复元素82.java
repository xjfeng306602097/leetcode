package 链表;

import java.util.List;

/**
 * 描述: 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaojunfeng
 * @date 2020/5/27 11:56
 **/
public class 删除排序链表中的重复元素82 {

    public static ListNode deleteDuplicates(ListNode head) {
        // 链表已经排序好，只需要一个个遍历比较前后值，如果存在重复数字，直接跳过，直到没有重复出现的数字
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 临时变量，用于定位头节点
        ListNode node = dummy;
        while (node.next != null && node.next.next != null) {
            if (node.next.val == node.next.next.val) {
                // 重复，一直遍历直到值不一致
                ListNode tmp = node.next;
                // 定位到不同的节点，修改node的next指向tmp;
                while (tmp != null && tmp.next != null && tmp.val == tmp.next.val) {
                    tmp = tmp.next;
                }
                // tmp.next与tmp值不一致，所以node.next指向tmp.next,寻找下一个节点
                node.next = tmp.next;
            } else {
                node = node.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(5);
        System.out.println(deleteDuplicates(node).toString());
    }
}
