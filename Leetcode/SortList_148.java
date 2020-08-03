import java.util.ArrayList;
import java.util.List;

public class SortList_148 {

    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        return helper(list, 0, list.size());
    }

    private ListNode helper(List<ListNode> list, int start, int end) {
        if (start == end) return null;
        if (end - start == 1) {
            ListNode node = list.get(start);
            node.next = null;
            return node;
        }

        int half = (end + start) / 2;
        ListNode lNode = helper(list, start, half);
        ListNode rNode = helper(list, half, end);
        ListNode head = null, node = null;
        while (lNode != null && rNode != null) {
            if (lNode.val < rNode.val) {
                if (head == null) head = lNode;
                if (node == null) node = lNode;
                else { node.next = lNode; node = node.next; }
                lNode = lNode.next;
            } else {
                if (head == null) head = rNode;
                if (node == null) node = rNode;
                else { node.next = rNode; node = node.next; }
                rNode = rNode.next;
            }
        }
        ListNode rest = (lNode != null) ? lNode : rNode;
        while (rest != null) {
            if (node == null) node = rest;
            else { node.next = rest; node = node.next; }
            rest = rest.next;
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
