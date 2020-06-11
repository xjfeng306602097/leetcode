package 链表;

/**
 * 描述: TODO
 *
 * @author xiaojunfeng
 * @date 2020/6/11 11:06
 **/
public class 删除链表中的节点237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
