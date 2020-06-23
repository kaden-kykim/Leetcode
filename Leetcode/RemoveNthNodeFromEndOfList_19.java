public class RemoveNthNodeFromEndOfList_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode checkEnd = head, checkNth = head;
        int length = 1;
        while (checkEnd.next != null) {
            checkEnd = checkEnd.next;
            if (n < length) { checkNth = checkNth.next; }
            length++;
        }
        if (length == n) return head.next;
        if (checkNth.next != null) checkNth.next = checkNth.next.next;
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
