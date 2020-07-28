import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer_138 {

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        int length = 1;
        Node cur = head;
        while ((cur = cur.next) != null) length++;
        Map<Node, Integer> map = new HashMap<>();
        Node[] nodes = new Node[length + 1];
        cur = head;
        for (int i = 0; i < length; ++i) {
            map.put(cur, i);
            nodes[i] = new Node(cur.val);
            cur = cur.next;
        }
        cur = head;
        for (int i = 0; i < length; ++i, cur = cur.next) {
            nodes[i].next = nodes[i + 1];
            if (cur.random != null) nodes[i].random = nodes[map.get(cur.random)];
        }
        return nodes[0];
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
