package leetcode146;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*public class LRUCache extends LinkedHashMap<Integer,Integer> {
    private int capacity;
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }
}*/
public class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        Node() {
        }
    }

    private Map<Integer, Node> cache = new HashMap<Integer, Node>();

    private int size;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果存在,先通过哈希表定位然后，将该节点移动至链表的头部
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                Node tail = removeTail(); // 获得并返回真正的尾部节点以便在缓存中删除
                cache.remove(tail.key);
                size--;
            }
        }else{
            node.val = value;
            moveToHead(node);
        }
    }
    // 移动到头部
    public void moveToHead(Node node) {
        // 先从原来的位置先剔除，再移动
        removeNode(node);
        addToHead(node);
    }

    // 将节点添加到头部
    public void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 删除节点
    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 删除尾部节点
    public Node removeTail() {
        Node res = tail.prev; // 真正的尾部节点
        removeNode(res);
        return res;
    }

}