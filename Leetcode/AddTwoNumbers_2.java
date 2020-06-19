public class AddTwoNumbers_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumNodes = new ListNode();
        ListNode result = sumNodes;
        ListNode iter1 = l1, iter2 = l2;

        int overflow = 0;
        while (iter1 != null || iter2 != null) {
            sumNodes.next = new ListNode();
            sumNodes = sumNodes.next;
            int sum = overflow;
            if (iter1 != null) {
                sum += iter1.val;
                iter1 = iter1.next;
            }
            if (iter2 != null) {
                sum += iter2.val;
                iter2 = iter2.next;
            }
            sumNodes.val = sum % 10;
            overflow = sum / 10;
        }

        if (overflow == 1) {
            sumNodes.next = new ListNode(1);
        }

        return result.next;
    }

}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}