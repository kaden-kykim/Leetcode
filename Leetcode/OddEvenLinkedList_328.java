public class OddEvenLinkedList_328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        int size = 1;
        ListNode procNode = head, lastNode = head;
        while (lastNode.next != null) { lastNode = lastNode.next; ++size; }
        for (int i = 0; i < size / 2; ++i) {
            lastNode = lastNode.next = procNode.next;
            procNode = procNode.next = lastNode.next;
            lastNode.next = null;
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
