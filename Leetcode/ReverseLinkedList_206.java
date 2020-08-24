public class ReverseLinkedList_206 {

    public ListNode reverseList(ListNode head) {
        ListNode tempNode = head, reverseNode = null;
        while (tempNode != null) {
            ListNode nextNode = tempNode.next;
            tempNode.next = reverseNode;
            reverseNode = tempNode;
            tempNode = nextNode;
        }
        return reverseNode;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
