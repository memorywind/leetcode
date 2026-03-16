package leetcode234;


public class huiwenlianbiao {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("1,2");
        String str = sb.toString();
        String str1 = sb.reverse().toString();
        System.out.println(str.equals(str1));
    }

    public static boolean isPalindrome(ListNode2 head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        String str = sb.toString();
//        int size = list.size();
//        for (int i = 0; i < size / 2; i++) {
//            if(list.get(i).val != list.get(size - i - 1).val) {
//                return false;
//            }
//        }
//        return true;
        String str1 = sb.reverse().toString();
        return str.equals(str1);
    }
}

class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2() {
    }

    ListNode2(int val) {
        this.val = val;
    }

    ListNode2(int val, ListNode2 next) {
        this.val = val;
        this.next = next;
    }
}
