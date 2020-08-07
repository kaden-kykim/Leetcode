public class IntersectionOfTwoLinkedLists_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;
        ListNode curA = headA, curB = headB;
        while (curA != null) { curA = curA.next; ++lengthA; }
        while (curB != null) { curB = curB.next; ++lengthB; }
        if (lengthA == 0 || lengthB == 0) return null;

        curA = headA; curB = headB;
        int gap = lengthA - lengthB;
        if (gap < 0) while (gap != 0) { curB = curB.next; ++gap; }
        else while (gap != 0) { curA = curA.next; --gap; }

        ListNode iNode = null;
        while (curA != null && curB != null) {
            if (iNode == null) iNode = (curA == curB) ? curA : null;
            curA = curA.next; curB = curB.next;
        }
        return iNode;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

}
