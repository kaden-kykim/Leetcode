import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII_142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        int count = 0;
        do {
            ++count;
            slow = slow.next;
            if (fast.next == null) return null;
            fast = fast.next.next;
            if (slow == null || fast == null) return null;
        } while (fast != slow);
        fast = slow = head;
        for (int i = 0; i < count; ++i) fast = fast.next;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return head;
            set.add(head);
            head = head.next;
        }
        return head;
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
