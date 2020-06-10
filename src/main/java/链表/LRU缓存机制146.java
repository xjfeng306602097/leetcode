package 链表;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述: LRU缓存机制146
 *
 * @author xiaojunfeng
 * @date 2020/5/25 13:35
 **/
public class LRU缓存机制146 {

    static class LRUCache {

        private ListNode first;

        private ListNode last;

        private int size;

        private int capacity;

        // 维护一个Cache,通过HashMap可以实现O(1)访问
        private Map<Integer, ListNode> cacheMap = new HashMap<Integer, ListNode>();

        class ListNode {

            ListNode prev;

            ListNode next;

            int key;

            int value;

            public ListNode() {

            }

            public ListNode(int key, int value) {
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

        public int get(int key) {
            ListNode node = cacheMap.get(key);
            if (node == null) {
                return -1;
            }
            return node.value;
        }

        public void put(int key, int value) {
            ListNode node = cacheMap.get(key);
            if (node == null) {
                node = new ListNode(key, value);
                // 每次添加都直接在cache、双端列表添加
                cacheMap.put(key, node);
                addNodeToHead(node);
                ++size;
                if (size > capacity) {
                    // 删除tail的前驱指针
                    node = removeTailNode();
                    cacheMap.remove(node.key);
                    --size;
                }
            } else {
                // 有对应的node节点，修改node的value值，并且维护双端链表，将节点调整到头
                node.value = value;
                moveNodeToHead(node);
            }
        }

        public void addNodeToHead(ListNode node) {
            node.next = first.next;
            node.prev = first;
            first.next.prev = node;
            first.next = node;
        }

        public void moveNodeToHead(ListNode node) {
            // 修改当前节点,当前节点的前一个指针的next等于当前节点的next
            // 修改当前节点的后一个指针的prev为当前节点的prev
            node.prev.next = node.next;
            node.next.prev = node.prev;
            // 将node放置在链表头
            node.next = first.next;
            node.prev = first;
            first.next.prev = node;
            first.next = node;
        }

        public ListNode removeTailNode() {
            // 获取最后的指针的前一个节点
            ListNode node = last.prev;
            // 调整当前节点的前驱后驱指针
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        obj.get(1);
        obj.put(3, 3);
        obj.get(2);
        obj.put(4, 4);
        obj.get(1);
        obj.get(3);
        obj.get(4);
    }


}
