package 链表;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: admin
 * @date: 2020/11/13 11:03
 * @description:
 */
public class LRUCache {

    private ListNode first;

    private ListNode last;

    private int capacity;

    private int size;

    Map<String, ListNode> cache = new HashMap<String, ListNode>();

    class ListNode {
        ListNode prev;
        ListNode next;
        String key;
        Object value;

        public ListNode() {

        }

        public ListNode(String key, Object value) {
            this.key = key;
            this.value = value;
        }

    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.first = new ListNode();
        this.last = new ListNode();
        this.last.prev = this.first;
        this.first.next = this.last;
    }

    public void put(String key, Object value) {
        //  查询是否有对应的节点
        ListNode node = cache.get(key);
        if (node == null) {
            node = new ListNode(key, value);
            cache.put(key, node);
            size++;
            // 加入链表头
            addNodeToHead(node);
            if (size > capacity) {
                // 大于容量的时候,触发链尾删除
                ListNode removeNode = removeTailNode();
                cache.remove(removeNode.key);
                // help gc
                removeNode = null;
                --size;
            }
        } else {
            node.value = value;
            // 更新完之后,修改数据到头节点
            moveNodeToHead(node);
        }
    }

    public void addNodeToHead(ListNode node) {
        node.next = this.first.next;
        node.prev = this.first;
        this.first.next.prev = node;
        this.first.next = node;
    }

    private void moveNodeToHead(ListNode node) {
        // 拆出对应的节点，将对应的链表节点扣出放到头节点后
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = this.first.next;
        node.prev = this.first;
        this.first.next.prev = node;
        this.first.next = node;
    }

    private ListNode removeTailNode() {
        ListNode removeNode = this.last.prev;
        removeNode.prev.next = this.last;
        removeNode.next.prev = removeNode.prev;
        return removeNode;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put("key1", 1);
        cache.put("key2", 2);
        cache.put("key3", 3);
        cache.put("key1", 2);
        cache.put("key4", 4);
        System.out.println("=============观察==============");
    }


}
