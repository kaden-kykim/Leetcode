import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle_141 {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && slow != null) {
            slow = slow.next;
            if (fast.next != null) fast = fast.next.next;
            else return false;
            if (fast == slow) return true;
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null) return false;
        ListNode cur = head;
        cur.val = Integer.MIN_VALUE;
        while (cur.next != null) {
            cur = cur.next;
            if (cur.val == Integer.MIN_VALUE) return true;
            else cur.val = Integer.MIN_VALUE;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null) return false;
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        set.add(cur);
        while (cur.next != null) {
            cur = cur.next;
            if (set.contains(cur)) return true;
            else set.add(cur);
        }
        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
