package leetcode25;

public class demo {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        ListNode groupPrev = dummy;
        while (true) {
            ListNode cur = groupPrev;
            int count = k;
            while (count > 0 &&  cur != null) {
                count -- ;
                cur =  cur.next;
            }
            // 如果cur为空，说明当前组不够k个
            if (cur == null) break;
            ListNode groupNext = cur.next;
            ListNode prev = groupNext;
            cur = groupPrev.next;
            ListNode tmp = null;

            while (cur != groupNext) {
                tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }
            tmp = groupPrev.next;
            groupPrev.next = prev;
            groupPrev = tmp;
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
