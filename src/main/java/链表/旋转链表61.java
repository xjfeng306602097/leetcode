package 链表;

/**
 * 描述: TODO
 *
 * @author xiaojunfeng
 * @date 2020/5/25 16:00
 **/
public class 旋转链表61 {

    public static ListNode rotateRight(ListNode head, int k) {
        // 先找出last节点
        ListNode last = null;
        if (head == null) {
            return null;
        }
        ListNode tmp = head.next;
        int n = 1;
        // 获取节点数
        while (tmp != null) {
            last = tmp;
            tmp = tmp.next;
            n++;
        }
        // 找出对应的最后一个节点之后,遍历k%n次,以最后的节点作为头结点
        if (last == null) {
            return head;
        }
        last.next = head;
        ListNode breakNode = head;
        for (int i = 1; i < n - k % n; i++) {
            breakNode = breakNode.next;
        }
        ListNode newHead = breakNode.next;
        breakNode.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode flipList = 旋转链表61.rotateRight(head, 2);
        System.out.println(flipList.toString());
    }

}
