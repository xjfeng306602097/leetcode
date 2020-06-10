package 链表;

/**
 * 描述: TODO
 *
 * @author xiaojunfeng
 * @date 2020/5/25 16:02
 **/
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[");
        if (this != null) {
            stringBuffer.append(val);
            if (this.next != null) {
                stringBuffer.append(",");
            }
            ListNode tmp = this.next;
            while (tmp != null) {
                stringBuffer.append(tmp.val);
                tmp = tmp.next;
                if (tmp != null) {
                    stringBuffer.append(",");
                }
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
