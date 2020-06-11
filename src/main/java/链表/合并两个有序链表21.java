package 链表;

/**
 * 描述: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaojunfeng
 * @date 2020/6/11 10:48
 **/
public class 合并两个有序链表21 {

    /**
     * 由于两个链表都是有序的，所以可以通过这种遍历的方式
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                // 放下一个节点接链
                pre = pre.next;
                l1 = l1.next;
            } else {
                pre.next = l2;
                // 放下一个节点接链
                pre = pre.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            pre.next = l1;
        } else {
            pre.next = l2;
        }
        return dummy.next;
    }

}
