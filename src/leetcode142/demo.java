package leetcode142;

public class demo {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            } else{
                return null; // 不存在环
            }
            if (slow == fast) {
                break; // 存在环
            }
        }
        if (slow != fast) {
            return null;
        }
        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
