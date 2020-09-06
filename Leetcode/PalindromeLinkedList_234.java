public class PalindromeLinkedList_234 {

    private ListNode compNode;

    public boolean isPalindrome(ListNode head) {
        compNode = head;
        return helper(head);
    }

    private boolean helper(ListNode node) {
        if (node == null) return true;
        boolean isPalindrome = helper(node.next) && node.val == compNode.val;
        compNode = compNode.next;
        return isPalindrome;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
