package p21;

public class Main {
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = null;
        ListNode next = null;
        while (l1 != null && l2 != null) {
            if (node == null) {
                node = new ListNode(0);
                next = node;
            } else {
                next.next = new ListNode(0);
                next = next.next;
            }
            if (l1.val < l2.val) {
                next.val = l1.val;
                l1 = l1.next;
            } else {
                next.val = l2.val;
                l2 = l2.next;
            }
        }
        if (node == null) {
            if (l1 != null) {
                return l1;
            } else {
                return l2;
            }
        }
        while(l1 != null) {
            next.next = new ListNode(0);
            next = next.next;
            next.val = l1.val;
            l1 = l1.next;
        }
        while(l2 != null) {
            next.next = new ListNode(0);
            next = next.next;
            next.val = l2.val;
            l2 = l2.next;
        }
        return node;
    }
}
