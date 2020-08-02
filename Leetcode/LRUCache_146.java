import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache_146 {

    private final Map<Integer, Node> lruMap;
    private final int capacity;

    private Node head, tail;

    public LRUCache_146(int capacity) {
        this.capacity = capacity;
        this.lruMap = new HashMap<>();

        // For the previous Solution
        this.lruMap1 = new HashMap<>();
        this.lruList1 = new ArrayList<>();
    }

    public int get(int key) {
        if (lruMap.containsKey(key)) {
            Node node = lruMap.get(key);
            put(node.key, node.value);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (lruMap.containsKey(key)) {
            Node node = lruMap.get(key);
            node.value = value;
            if (node != head) {
                if (node == tail) {
                    tail = node.prev;
                    tail.next = null;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                node.prev = null;
                head.prev = node;
                node.next = head;
                head = node;
            }
        } else {
            Node node = new Node(key, value);
            lruMap.put(key, node);
            if (head == null) {
                head = tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
            if (capacity < lruMap.size()) {
                lruMap.remove(tail.key);
                tail.prev.next = null;
                tail = tail.prev;
            }
        }
    }

    private final List<Integer> lruList1;
    private final Map<Integer, Integer> lruMap1;

    public int get1(int key) {
        if (lruMap.containsKey(key)) {
            lruList1.remove((Integer) key);
            lruList1.add(0, key);
        }
        return lruMap1.getOrDefault(key, -1);
    }

    public void put1(int key, int value) {
        if (lruMap.containsKey(key)) lruList1.remove((Integer) key);
        lruList1.add(0, key);
        lruMap1.put(key, value);
        if (capacity < lruList1.size())
            lruMap.remove(lruList1.remove(lruList1.size() - 1));
    }

    private static class Node {
        Node prev, next;
        int key, value;
        Node(int key, int value) { this.key = key; this.value = value; }
    }

}
