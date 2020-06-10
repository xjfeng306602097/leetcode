package 链表;

/**
 * 描述: TODO
 *
 * @author xiaojunfeng
 * @date 2020/6/1 11:04
 **/
public class 反转链表206 {

    public ListNode reverseList(ListNode head) {
        // 递归做法
        /*if (head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;*/
        // 非递归方法，遍历
        if (head.next == null) {
            return head;
        }
        //前指针节点
        ListNode prev = null;
        //当前指针节点
        ListNode curr = head;
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (curr != null) {
            ListNode nextTemp = curr.next; //临时节点，暂存当前节点的下一节点，用于后移
            curr.next = prev; //将当前节点指向它前面的节点
            prev = curr; //前指针后移
            curr = nextTemp; //当前指针后移
        }
        return prev.next;
    }

}
