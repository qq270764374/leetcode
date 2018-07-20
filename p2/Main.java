package p2;

public class Main {
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int scale = 0;
        ListNode head = new ListNode(0);
        ListNode now = head;
        while(l1!=null&&l2!=null) {
            int sum = l1.val + l2.val + scale;
            if (sum >= 10) {
                sum -=10;
                scale = 1;
            } else {
                scale = 0;
            }
            now.next = new ListNode(sum);
            l1 = l1.next;
            l2 = l2.next;
            now = now.next;
        }
        while(l1!=null) {
            int sum = l1.val + scale;
            if (sum >= 10) {
                sum -= 10;
                scale = 1;
            } else {
                scale = 0;
            }
            now.next = new ListNode(sum);
            l1 = l1.next;
            now = now.next;
        }
        while(l2 != null) {
            int sum = l2.val + scale;
            if (sum >= 10) {
                sum -= 10;
                scale = 1;
            } else {
                scale = 0;
            }
            now.next = new ListNode(sum);
            l2 = l2.next;
            now = now.next;
        }
        if (scale == 1) {
            now.next = new ListNode(scale);
            now = now.next;
            scale = 0;
        }
        return head.next;
    }
}
