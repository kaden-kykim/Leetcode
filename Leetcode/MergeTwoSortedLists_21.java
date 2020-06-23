public class MergeTwoSortedLists_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
