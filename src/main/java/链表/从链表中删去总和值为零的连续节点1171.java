package 链表;

/**
 * 描述: 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * <p>
 * 删除完毕后，请你返回最终结果链表的头节点。
 * <p>
 *  
 * <p>
 * 你可以返回任何满足题目要求的答案。
 * <p>
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 * 示例 2：
 * <p>
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 * 示例 3：
 * <p>
 * 输入：head = [1,2,3,-3,-2]
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 给你的链表中可能有 1 到 1000 个节点。
 * 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaojunfeng
 * @date 2020/5/27 17:16
 **/
public class 从链表中删去总和值为零的连续节点1171 {

    public static ListNode removeZeroSumSublists(ListNode head) {
        // 1->2->-3->3->1,那么就需要删除1->2->-3
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (node != null && node.next != null) {
            ListNode cur = node.next;
            int sum = cur.val;
            ListNode next = cur.next;
            // 为0直接跳过
            if (sum == 0) {
                node.next = next == null ? null : next;
                continue;
            }
            while (next != null) {
                sum += next.val;
                if (sum == 0) {
                    break;
                } else {
                    next = next.next;
                }
            }
            if (next != null) {
                node.next = next.next;
            } else {
                node = node.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(-3);
        node1.next.next.next = new ListNode(3);
        node1.next.next.next.next = new ListNode(1);
        ListNode node = 从链表中删去总和值为零的连续节点1171.removeZeroSumSublists(node1);
        System.out.println(node.toString());
    }
}
