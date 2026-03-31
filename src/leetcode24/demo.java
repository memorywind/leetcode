package leetcode24;

public class demo {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        ListNode first = head;
        ListNode second = null;
        while (first != null && first.next != null) {
            second = first.next;
            ListNode next = second.next;
            prev.next = second;
            second.next = first;
            first.next = next;
            prev = first;
            first = next;
        }
        return dummy.next;
    }

    public class ListNode {
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
}
