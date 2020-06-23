import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<NodeValue> pQueue = new PriorityQueue<>();

        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                pQueue.add(new NodeValue(lists[i].val, i));
                lists[i] = lists[i].next;
            }
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (pQueue.size() != 0) {
            NodeValue nodeValue = pQueue.poll();
            cur = cur.next = new ListNode(nodeValue.val);
            ListNode indexNode = lists[nodeValue.index];
            if (indexNode != null) {
                nodeValue.val = indexNode.val;
                pQueue.add(nodeValue);
                lists[nodeValue.index] = indexNode.next;
            }
            if (pQueue.size() == 1) {
                nodeValue = pQueue.poll();
                cur = cur.next = new ListNode(nodeValue.val);
                cur.next = lists[nodeValue.index];
            }
        }
        return dummy.next;
    }

    public ListNode mergeNLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int i, j = lists.length - 1;
        while (j > 0) {
            i = 0;
            while (i < j) {
                lists[i] = mergeTwoLists(lists[i], lists[j]);
                i++; j--;
            }
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode i1 = l1, i2 = l2;
        ListNode dummy = new ListNode(), cur = dummy;

        while (i1 != null && i2 != null) {
            if (i1.val < i2.val) {
                cur = cur.next = new ListNode(i1.val);
                i1 = i1.next;
            } else {
                cur = cur.next = new ListNode(i2.val);
                i2 = i2.next;
            }
        }
        cur.next = (i1 != null) ? i1 : i2;

        return dummy.next;
    }

    private static class NodeValue implements Comparable<NodeValue> {
        int val, index;
        NodeValue(int val, int index) { this.val = val; this.index = index; }
        @Override public int compareTo(NodeValue rhs) { return Integer.compare(val, rhs.val); }
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
